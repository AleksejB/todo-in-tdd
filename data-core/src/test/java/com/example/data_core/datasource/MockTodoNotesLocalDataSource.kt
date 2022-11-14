package com.example.data_core.datasource

import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.data_core.database.entity.NoteEntity
import com.example.domain_core.model.Note
import java.util.NoSuchElementException

//class MockTodoNotesLocalDataSource(): TodoNotesLocalDataSource {
//
//    private val noteEntities = listOf<NoteEntity>(
//        NoteEntity(
//            id = 0,
//            text = "note1"
//        ),
//        NoteEntity(
//            id = 1,
//            text = "note2"
//        ),
//        NoteEntity(
//            id = 2,
//            text = "note3"
//        )
//    )
//
//    override suspend fun getNoteById(noteId: Int): Note? {
//        return try {
//            noteEntities.first { it.id == noteId }
//        } catch (e: NoSuchElementException) {
//            null
//        }
//    }
//}