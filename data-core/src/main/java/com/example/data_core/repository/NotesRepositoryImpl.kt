package com.example.data_core.repository

import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.domain_core.datasource.TodoNotesRemoteDataSource
import com.example.domain_core.model.TodoNote
import com.example.domain_core.repository.NotesRepository

class NotesRepositoryImpl constructor(
    private val todoNotesLocalDataSource: TodoNotesLocalDataSource,
    private val todoNotesRemoteDataSource: TodoNotesRemoteDataSource
): NotesRepository {

    override suspend fun getNoteById(todoNoteId: Int): TodoNote? {
        return todoNotesLocalDataSource.getTodoNoteById(todoNoteId)
    }

    //This is not part of the app, and is purely for experimentation and learning tdd
    override suspend fun getCombinedNoteTextFromLocalAndRemote(todoNoteId: Int): String? {
        val localNote = todoNotesLocalDataSource.getTodoNoteById(todoNoteId)
        todoNotesRemoteDataSource.getNoteByIdFromRemote(todoNoteId).fold(
            onSuccess = {
                if (localNote?.text == it?.text) {
                    return it?.text
                } else {
                    return localNote?.text + it?.text
                }
            },
            onFailure = {
                return null
            }
        )
    }

}