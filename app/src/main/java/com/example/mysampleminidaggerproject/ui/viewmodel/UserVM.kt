package com.example.mysampleminidaggerproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mysampleminidaggerproject.core.model.UserM
import com.example.mysampleminidaggerproject.core.repository.UserRepository
import com.example.mysampleminidaggerproject.utils.NetworkHelper
import com.example.mysampleminidaggerproject.utils.Resource
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart

class UserVM @Inject constructor (private val userRepository: UserRepository, private val networkHelper: NetworkHelper) :
    ViewModel() {
    private var userLiveData: LiveData<Resource<List<UserM>>>? = null

    fun getUsersUsingFlow(): LiveData<Resource<List<UserM>>>? {
        userLiveData = liveData(Dispatchers.IO) {
            if (networkHelper.isNetworkConnected()) {
                userRepository.getUsersFromServer()
                    .onStart { emit(Resource.loading(null)) }
                    .catch { exeption -> emit(Resource.error(exeption.cause.toString(), null)) }
                    .collect {
                        if (it.isSuccessful) {
                            emit(Resource.success(it.body()))
                            it.body()?.let { it1 -> userRepository.insertUsersIntoLocalDb(it1) }
                        }
                    }
            } else {
                userRepository.getUsersFromLocal()
                    .onStart { emit(Resource.loading(null)) }
                    .catch { exeption ->emit(Resource.error(exeption.message.toString(),null)) }
                    .collect { emit(Resource.success(it)) }
            }

        }
        return userLiveData
    }
}
