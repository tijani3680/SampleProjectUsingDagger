package com.example.mysampleminidaggerproject.core.repository

import com.example.mysampleminidaggerproject.core.model.UserM
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface UserRepository {
    suspend fun getUsersFromServer(): Flow<Response<List<UserM>>>
    suspend fun getUsersFromLocal():  Flow<List<UserM>>

    suspend fun insertUsersIntoLocalDb(users:List<UserM>)

}
