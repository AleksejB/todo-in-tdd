package com.example.domain_core.model

interface Note {
    val id: Long
    val noteTitle: String
    val text: String
    val type: NoteType
}

