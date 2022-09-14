package com.example.domain_core.datasource

import com.example.domain_core.model.TodoNote

//for experimenting with testing
interface TodoNotesRemoteDataSource {
    suspend fun getNoteByIdFromRemote(noteId: Int): Result<TodoNote?>
}