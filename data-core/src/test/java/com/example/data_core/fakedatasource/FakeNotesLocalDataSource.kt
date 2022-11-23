package com.example.data_core.fakedatasource

import com.example.data_core.database.entity.NoteEntity
import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.Note
import com.example.domain_core.model.NoteType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNotesLocalDataSource(): NotesLocalDataSource<NoteEntity> {

    val noteEntities = listOf<NoteEntity>(
        NoteEntity(
            id = 0,
            noteTitle = "note1",
            text = "noteText1",
            type = NoteType.NOTE
        ),
        NoteEntity(
            id = 1,
            noteTitle = "note2",
            text = "noteText2",
            type = NoteType.NOTE
        ),
        NoteEntity(
            id = 2,
            noteTitle = "note3",
            text = "noteText3",
            type = NoteType.TODO
        )
    )

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
        return flow { emit(noteEntities) }
    }
}