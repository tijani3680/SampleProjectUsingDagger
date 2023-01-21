package com.example.mysampleminidaggerproject.core.dataSource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mysampleminidaggerproject.core.model.UserM
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserUsers(users: List<UserM>)

    @Query("SELECT * FROM tbl_users ORDER BY id DESC")
    fun getUsers(): Flow<List<UserM>>
}
