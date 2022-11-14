package com.example.domain_core.repository

import com.example.data_core.database.entity.TodoNote

interface NotesRepository {
    suspend fun getNoteById(noteId: Int): com.example.data_core.database.entity.TodoNote?
    suspend fun getCombinedNoteTextFromLocalAndRemote(noteId: Int): String?
}