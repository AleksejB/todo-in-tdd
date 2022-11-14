package com.example.domain_core.datasource

import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow

interface TodoNotesLocalDataSource {
    fun getNoteById(noteId: Int): Flow<Note?>
    suspend fun insertNote(note: Note)
    suspend fun deleteNote(note: Note)
}