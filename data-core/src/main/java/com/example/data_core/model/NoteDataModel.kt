package com.example.data_core.model

import com.example.domain_core.model.Note
import com.example.domain_core.model.NoteType

data class NoteDataModel(
    override val id: Long,
    override val noteTitle: String,
    override val text: String,
    override val type: NoteType
): Note