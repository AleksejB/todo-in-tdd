package com.example.data_core.model

import androidx.room.Entity
import com.example.domain_core.model.Note
import com.example.domain_core.model.NoteType

//@Entity
data class NoteEntity(
    override val id: Int,
    override val noteTitle: String,
    override val text: String,
    override val type: NoteType
): Note