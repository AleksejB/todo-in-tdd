package com.example.data_core.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.data_core.database.entity.NoteEntity
import com.example.domain_core.model.Note
import kotlinx.coroutines.flow.Flow

//@Dao
//interface TodoNoteDao: TodoNotesLocalDataSource {
//
//    @Insert
//    override suspend fun insertNote(note: Note)
//
//    @Delete
//    override suspend fun deleteNote(note: Note)
//
////    @Query("SELECT * FROM todoNote WHERE id = :todoNoteId")
////    override suspend fun getTodoNoteById(todoNoteId: Int): TodoNote?
//
//    @Query("SELECT * FROM todoNote WHERE id = :noteId")
//    override fun getNoteById(noteId: Int): Flow<Note?>
//}