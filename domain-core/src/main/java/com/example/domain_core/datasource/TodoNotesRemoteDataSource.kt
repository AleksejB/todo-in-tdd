package com.example.domain_core.datasource

import com.example.data_core.database.entity.TodoNote

//for experimenting with testing
interface TodoNotesRemoteDataSource {
    suspend fun getNoteByIdFromRemote(noteId: Int): Result<com.example.data_core.database.entity.TodoNote?>
}