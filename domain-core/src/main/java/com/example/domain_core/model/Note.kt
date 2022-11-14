package com.example.domain_core.model

interface Note {
    val id: Int
    val noteTitle: String
    val text: String
    val type: NoteType
}

