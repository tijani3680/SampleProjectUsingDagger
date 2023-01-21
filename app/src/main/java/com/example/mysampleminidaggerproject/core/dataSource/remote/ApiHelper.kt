package com.example.mysampleminidaggerproject.core.dataSource.remote

import com.example.mysampleminidaggerproject.core.model.UserM
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {

    suspend fun getUsers(): Flow<Response<List<UserM>>>
}
