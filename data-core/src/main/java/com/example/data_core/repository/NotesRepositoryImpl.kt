package com.example.data_core.repository

import com.example.data_core.database.entity.NoteEntity
import com.example.data_core.model.NoteDataModel
import com.example.data_core.util.toNoteDataModel
import com.example.data_core.util.toNoteEntity
import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note
import com.example.domain_core.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NotesRepositoryImpl @Inject constructor(
    private val notesLocalDataSource: NotesLocalDataSource<NoteEntity>
): NotesRepository {

    override suspend fun getNoteById(noteId: Long): Flow<NoteDataModel?> {
        return notesLocalDataSource.getNoteById(noteId).map { it?.toNoteDataModel() }
    }

    override suspend fun getAllNotes(): Flow<List<NoteDataModel>> {
        return notesLocalDataSource.getAllNotes().map { listOfNotes ->
            listOfNotes.map { it.toNoteDataModel() }
        }
    }

    override suspend fun deleteNoteById(noteId: Long) {
        notesLocalDataSource.deleteNoteById(noteId)
    }

    override suspend fun insertNote(note: Note): Long {
        return notesLocalDataSource.insertNote(note.toNoteDataModel().toNoteEntity())
    }

//    This is not part of the app, and is purely for experimentation and learning tdd
//    This is meant to be part of domain? No, it uses the data layer
//    override suspend fun getCombinedNoteTextFromLocalAndRemote(todoNoteId: Int): String? {
//        val localNote = todoNotesLocalDataSource.getTodoNoteById(todoNoteId)
//        todoNotesRemoteDataSource.getNoteByIdFromRemote(todoNoteId).fold(
//            onSuccess = {
//                if (localNote?.text == it?.text) {
//                    return it?.text
//                } else {
//                    return localNote?.text + it?.text
//                }
//            },
//            onFailure = {
//                return null
//            }
//        )
//    }
}