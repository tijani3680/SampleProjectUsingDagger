package com.example.mysampleminidaggerproject.core.dataSource.local
import com.example.mysampleminidaggerproject.core.model.UserM
import kotlinx.coroutines.flow.Flow

interface MainDaoHelper {
    suspend fun inserUsers(users: List<UserM>)
    fun getUsers(): Flow<List<UserM>>
}
