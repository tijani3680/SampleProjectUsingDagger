package com.example.mysampleminidaggerproject.core.dataSource.remote

import com.example.mysampleminidaggerproject.core.model.UserM
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getUsers(): Response<List<UserM>>
}
