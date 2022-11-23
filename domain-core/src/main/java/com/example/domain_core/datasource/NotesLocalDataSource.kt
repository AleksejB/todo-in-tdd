package com.example.domain_core.datasource

import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesLocalDataSource<T> {
    fun getNoteById(noteId: Long): Flow<T?>
    suspend fun insertNote(note: T): Long
    suspend fun deleteNoteById(noteId: Long)
    fun getAllNotes(): Flow<List<T>>
}