package com.example.data_core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain_core.model.NoteType

@Entity(tableName = "todoNote")
data class NoteEntity(
    @PrimaryKey val id: Int,
    val noteTitle: String,
    val text: String,
    val noteType: NoteType
)
