package com.example.data_core.datasource

import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note
import java.util.NoSuchElementException

class MockNotesLocalDataSource(): NotesLocalDataSource {

    private val notes = listOf<Note>(
        Note(
            id = 0,
            text = "note1"
        ),
        Note(
            id = 1,
            text = "note2"
        ),
        Note(
            id = 2,
            text = "note3"
        )
    )

    override suspend fun getNoteById(noteId: Int): Note? {
        return try {
            notes.first { it.id == noteId }
        } catch (e: NoSuchElementException) {
            null
        }
    }
}