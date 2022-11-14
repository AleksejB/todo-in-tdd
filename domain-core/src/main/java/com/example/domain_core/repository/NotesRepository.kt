package com.example.domain_core.repository

import com.example.domain_core.model.Note

interface NotesRepository {
    suspend fun getNoteById(noteId: Int): Note?

    //This function is for experimentation with TDD
//    suspend fun getCombinedNoteTextFromLocalAndRemote(noteId: Int): String?
}