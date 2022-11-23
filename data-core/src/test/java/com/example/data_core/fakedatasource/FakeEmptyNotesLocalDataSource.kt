package com.example.data_core.fakedatasource

import com.example.data_core.database.entity.NoteEntity
import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeEmptyNotesLocalDataSource(): NotesLocalDataSource<NoteEntity> {

    private val noteEntities = emptyList<NoteEntity>()

    override fun getNoteById(noteId: Int): Flow<NoteEntity?> {
        return flow { emit(noteEntities.firstOrNull { it.id == noteId }) }
    }

    override suspend fun insertNote(note: NoteEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: NoteEntity) {
        TODO("Not yet implemented")
    }

    override fun getAllNotes(): Flow<List<NoteEntity>> {
        return flow { emit(emptyList()) }
    }

}