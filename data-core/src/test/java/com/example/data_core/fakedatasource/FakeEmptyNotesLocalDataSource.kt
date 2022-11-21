package com.example.data_core.fakedatasource

import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeEmptyNotesLocalDataSource(): NotesLocalDataSource<Note> {

    private val noteEntities = emptyList<Note>()

    override fun getNoteById(noteId: Int): Flow<Note?> {
        return flow { emit(noteEntities.firstOrNull { it.id == noteId }) }
    }

    override suspend fun insertNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }

    override fun getAllNotes(): Flow<List<Note>?> {
        return flow { emit(emptyList()) }
    }

}