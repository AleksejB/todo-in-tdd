package com.example.data_core.datasource

import com.example.domain_core.datasource.NotesRemoteDataSource
import com.example.domain_core.model.Note
import java.util.NoSuchElementException

class MockNotesRemoteDataSource: NotesRemoteDataSource {

    private val notes = listOf<Note>(
        Note(
            id = 0,
            text = "note1"
        ),
        Note(
            id = 1,
            text = "remoteNote2"
        ),
        Note(
            id = 4,
            text = "remoteNote4"
        )
    )

    override suspend fun getNoteByIdFromRemote(noteId: Int): Result<Note?> {
        return try {
            val note = notes.first { it.id == noteId }
            Result.success(note)
        } catch (e: NoSuchElementException) {
            Result.failure(e)
        }
    }
}