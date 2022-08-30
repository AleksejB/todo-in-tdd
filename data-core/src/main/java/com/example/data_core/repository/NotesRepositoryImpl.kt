package com.example.data_core.repository

import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note
import com.example.domain_core.repository.NotesRepository

class NotesRepositoryImpl constructor(
    private val notesLocalDataSource: NotesLocalDataSource
): NotesRepository {

    override suspend fun getNoteById(noteId: Int): Note? {
        return notesLocalDataSource.getNoteById(noteId)
    }

}