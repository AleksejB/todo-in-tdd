package com.example.domain_core.datasource

import com.example.domain_core.model.Note

interface NotesRemoteDataSource {
    suspend fun getNoteByIdFromRemote(noteId: Int): Result<Note?>
}