package com.example.data_core.datasource

import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.domain_core.model.TodoNote

class MockTodoNotesLocalDataSourceEmpty(): TodoNotesLocalDataSource {

    private val todoNotes = emptyList<TodoNote>()

    override suspend fun getTodoNoteById(noteId: Int): TodoNote? {
        return null
    }
}