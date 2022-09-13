package com.example.data_core.repository

import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.datasource.NotesRemoteDataSource
import com.example.domain_core.model.Note
import com.example.domain_core.repository.NotesRepository

class NotesRepositoryImpl constructor(
    private val notesLocalDataSource: NotesLocalDataSource,
    private val notesRemoteDataSource: NotesRemoteDataSource
): NotesRepository {

    override suspend fun getNoteById(noteId: Int): Note? {
        return notesLocalDataSource.getNoteById(noteId)
    }

    override suspend fun getCombinedNoteTextFromLocalAndRemote(noteId: Int): String? {
        val localNote = notesLocalDataSource.getNoteById(noteId)
        val noteFromRemote = notesRemoteDataSource.getNoteByIdFromRemote(noteId)

        if (localNote == null) return null
        if (noteFromRemote.getOrNull() == null) return null

        if (localNote.text == noteFromRemote.getOrNull()!!.text)



    }

}