package com.example.data_core.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.data_core.database.entity.NoteEntity

@Dao
interface TodoNoteDao: TodoNotesLocalDataSource {

    @Insert
    override suspend fun insertTodoNote(noteEntity: NoteEntity)

    @Delete
    override suspend fun deleteTodoNote(noteEntity: NoteEntity)

//    @Query("SELECT * FROM todoNote WHERE id = :todoNoteId")
//    override suspend fun getTodoNoteById(todoNoteId: Int): TodoNote?

    @Query("SELECT * FROM todoNote WHERE id = :todoNoteId")
    override suspend fun getTodoNoteById(todoNoteId: Int): NoteEntity?
}