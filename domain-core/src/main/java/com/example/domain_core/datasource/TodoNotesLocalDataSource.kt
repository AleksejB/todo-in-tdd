package com.example.domain_core.datasource

import com.example.domain_core.model.TodoNote

interface TodoNotesLocalDataSource {
    suspend fun getTodoNoteById(todoNoteId: Int): TodoNote?
    suspend fun insertTodoNote(todoNote: TodoNote)
    suspend fun deleteTodoNote(todoNote: TodoNote)
}