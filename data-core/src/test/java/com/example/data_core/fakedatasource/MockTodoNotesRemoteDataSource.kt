package com.example.data_core.fakedatasource

//This here was left from experimentation
//import com.example.domain_core.datasource.TodoNotesRemoteDataSource
//import com.example.data_core.database.entity.NoteEntity
//import java.util.NoSuchElementException
//
//class MockTodoNotesRemoteDataSource: TodoNotesRemoteDataSource {
//
//    private val noteEntities = listOf<NoteEntity>(
//        NoteEntity(
//            id = 0,
//            text = "note1"
//        ),
//        NoteEntity(
//            id = 1,
//            text = "remoteNote2"
//        ),
//        NoteEntity(
//            id = 4,
//            text = "remoteNote4"
//        )
//    )
//
//    override suspend fun getNoteByIdFromRemote(noteId: Int): Result<NoteEntity?> {
//        return try {
//            val note = noteEntities.first { it.id == noteId }
//            Result.success(note)
//        } catch (e: NoSuchElementException) {
//            Result.failure(e)
//        }
//    }
//}