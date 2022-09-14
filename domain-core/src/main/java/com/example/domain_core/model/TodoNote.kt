package com.example.domain_core.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoNote")
data class TodoNote(
    @PrimaryKey val id: Int,
    val text: String
)
