package com.example.data_core.datasource

import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.domain_core.model.TodoNote
import java.util.NoSuchElementException

class MockTodoNotesLocalDataSource(): TodoNotesLocalDataSource {

    private val todoNotes = listOf<TodoNote>(
        TodoNote(
            id = 0,
            text = "note1"
        ),
        TodoNote(
            id = 1,
            text = "note2"
        ),
        TodoNote(
            id = 2,
            text = "note3"
        )
    )

    override suspend fun getTodoNoteById(noteId: Int): TodoNote? {
        return try {
            todoNotes.first { it.id == noteId }
        } catch (e: NoSuchElementException) {
            null
        }
    }
}