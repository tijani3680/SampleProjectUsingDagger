package com.example.mysampleminidaggerproject.core.repository

import com.example.mysampleminidaggerproject.core.dataSource.local.MainDaoHelper
import com.example.mysampleminidaggerproject.core.dataSource.remote.ApiHelper
import com.example.mysampleminidaggerproject.core.model.UserM
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class UserRepositoryImpl @Inject constructor (private val apiHelper: ApiHelper,private val mainDaoHelper: MainDaoHelper) : UserRepository {
    override suspend fun getUsersFromServer(): Flow<Response<List<UserM>>> {
        return apiHelper.getUsers()
    }

    override suspend fun getUsersFromLocal(): Flow<List<UserM>> {
        return mainDaoHelper.getUsers()
    }

    override suspend fun insertUsersIntoLocalDb(users: List<UserM>) {
        mainDaoHelper.inserUsers(users)
    }
}

