package com.example.mysampleminidaggerproject.core.dataSource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mysampleminidaggerproject.core.model.UserM

@Database(entities = arrayOf(UserM::class), version = 1, exportSchema = false)

abstract class DatabaseHelper : RoomDatabase() {
    abstract val mainDao: MainDao
}
