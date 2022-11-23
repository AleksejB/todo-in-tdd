package com.example.data_core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain_core.model.Note
import com.example.domain_core.model.NoteType

@Entity(tableName = "todoNote")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) override val id: Long,
    override val noteTitle: String,
    override val text: String,
    override val type: NoteType
): Note
