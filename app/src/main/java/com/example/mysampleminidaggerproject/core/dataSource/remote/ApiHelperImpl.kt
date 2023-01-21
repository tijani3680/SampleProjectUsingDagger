package com.example.mysampleminidaggerproject.core.dataSource.remote

import com.example.mysampleminidaggerproject.core.model.UserM
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers(): Flow<Response<List<UserM>>> {
        return flow { emit(apiService.getUsers()) }.flowOn(Dispatchers.IO)
    }
}


