package com.example.data_core.datasource

import com.example.domain_core.datasource.TodoNotesRemoteDataSource
import com.example.domain_core.model.TodoNote
import java.util.NoSuchElementException

class MockTodoNotesRemoteDataSource: TodoNotesRemoteDataSource {

    private val todoNotes = listOf<TodoNote>(
        TodoNote(
            id = 0,
            text = "note1"
        ),
        TodoNote(
            id = 1,
            text = "remoteNote2"
        ),
        TodoNote(
            id = 4,
            text = "remoteNote4"
        )
    )

    override suspend fun getNoteByIdFromRemote(noteId: Int): Result<TodoNote?> {
        return try {
            val note = todoNotes.first { it.id == noteId }
            Result.success(note)
        } catch (e: NoSuchElementException) {
            Result.failure(e)
        }
    }
}