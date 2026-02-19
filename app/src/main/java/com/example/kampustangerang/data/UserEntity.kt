package com.example.kampustangerang.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val school: String,
    val userClass: String,
    val interest: String,
    val password: String
)
