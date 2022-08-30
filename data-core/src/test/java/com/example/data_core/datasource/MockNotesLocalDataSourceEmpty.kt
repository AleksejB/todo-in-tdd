package com.example.data_core.datasource

import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note

class MockNotesLocalDataSourceEmpty(): NotesLocalDataSource {

    private val notes = emptyList<Note>()

    override suspend fun getNoteById(noteId: Int): Note? {
        return null
    }
}