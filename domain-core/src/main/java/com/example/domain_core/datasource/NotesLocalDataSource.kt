package com.example.domain_core.datasource

import com.example.domain_core.model.Note

interface NotesLocalDataSource {
    //Will try observing one note, to and updating the db directly, rather than state, to see how that will look
    suspend fun getNoteById(noteId: Int): Note?
}