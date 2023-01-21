package com.example.mysampleminidaggerproject.core.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_users")
data class UserM(
    @PrimaryKey
    @NonNull
    val id: Int,
    val title: String,
    val userId: Int,
    val body: String
)
