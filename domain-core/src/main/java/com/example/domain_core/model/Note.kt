package com.example.domain_core.model

data class Note(
    val id: Int,
    val noteTitle: String,
    val text: String,
    val type: NoteType
)

