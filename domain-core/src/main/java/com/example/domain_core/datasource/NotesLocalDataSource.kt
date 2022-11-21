package com.example.domain_core.datasource

import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesLocalDataSource<T> {
    fun getNoteById(noteId: Int): Flow<T?>
    suspend fun insertNote(note: T)
    suspend fun deleteNote(note: T)
    fun getAllNotes(): Flow<List<T>>
}