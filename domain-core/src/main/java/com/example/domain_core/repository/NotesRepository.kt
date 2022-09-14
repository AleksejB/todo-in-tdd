package com.example.domain_core.repository

import com.example.domain_core.model.TodoNote

interface NotesRepository {
    suspend fun getNoteById(noteId: Int): TodoNote?
    suspend fun getCombinedNoteTextFromLocalAndRemote(noteId: Int): String?
}