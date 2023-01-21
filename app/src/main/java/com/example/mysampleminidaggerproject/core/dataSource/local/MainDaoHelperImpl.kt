package com.example.mysampleminidaggerproject.core.dataSource.local

import com.example.mysampleminidaggerproject.core.model.UserM
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MainDaoHelperImpl @Inject constructor(private val mainDao: MainDao) : MainDaoHelper {
    override suspend fun inserUsers(users: List<UserM>) {
        mainDao.inserUsers(users)
    }

    override fun getUsers(): Flow<List<UserM>> {
        return mainDao.getUsers()
    }
}
