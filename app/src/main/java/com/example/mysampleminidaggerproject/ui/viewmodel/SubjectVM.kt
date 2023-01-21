package com.example.mysampleminidaggerproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mysampleminidaggerproject.core.model.SubjectM
import com.example.mysampleminidaggerproject.utils.Resource
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SubjectVM @Inject constructor() :ViewModel() {

    private var subjectLiveData: LiveData<Resource<List<SubjectM>>>? = null

    fun getSubject(): LiveData<Resource<List<SubjectM>>>? {
        subjectLiveData = liveData(Dispatchers.IO) {
            generateSubjects()
                .catch { exception -> emit(Resource.error(exception.cause.toString(), null)) }
                .collect {
                    emit(Resource.success(it))
                }


        }
        return subjectLiveData

    }


    private suspend fun generateSubjects(): Flow<ArrayList<SubjectM>> {
        return flow {
            var subjects = arrayListOf<SubjectM>()
            subjects.add(SubjectM(1, "Data Store"))
            subjects.add(SubjectM(2, "Kotlin Flow"))
            subjects.add(SubjectM(3, "Kotlin Class Delegation"))
            subjects.add(SubjectM(4, "Kotlin Properties Delegation"))
            subjects.add(SubjectM(5, "Kotlin Observable Delegation"))
            emit(subjects)
        }.flowOn(Dispatchers.IO)
    }
}
