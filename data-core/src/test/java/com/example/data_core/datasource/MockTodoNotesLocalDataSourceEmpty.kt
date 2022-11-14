package com.example.data_core.datasource

import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.data_core.database.entity.NoteEntity

class MockTodoNotesLocalDataSourceEmpty(): TodoNotesLocalDataSource {

    private val noteEntities = emptyList<NoteEntity>()

    override suspend fun getTodoNoteById(noteId: Int): NoteEntity? {
        return null
    }
}