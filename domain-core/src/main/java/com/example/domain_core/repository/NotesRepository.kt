package com.example.domain_core.repository

import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun getNoteById(noteId: Int): Flow<Note?>
    suspend fun getAllNotes(): Flow<List<Note>?>

    //This function is for experimentation with TDD
//    suspend fun getCombinedNoteTextFromLocalAndRemote(noteId: Int): String?
}