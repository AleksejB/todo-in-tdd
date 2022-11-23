package com.example.domain_core.repository

import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun getNoteById(noteId: Long): Flow<Note?>
    suspend fun getAllNotes(): Flow<List<Note>>
    suspend fun insertNote(note: Note): Long
    suspend fun deleteNoteById(noteId: Long)

    //This function is for experimentation with TDD
//    suspend fun getCombinedNoteTextFromLocalAndRemote(noteId: Int): String?
}