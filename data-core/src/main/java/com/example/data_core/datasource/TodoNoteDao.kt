package com.example.data_core.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.domain_core.datasource.TodoNotesLocalDataSource
import com.example.domain_core.model.TodoNote

@Dao
interface TodoNoteDao: TodoNotesLocalDataSource {

    @Insert
    override suspend fun insertTodoNote(todoNote: TodoNote)

    @Delete
    override suspend fun deleteTodoNote(todoNote: TodoNote)

//    @Query("SELECT * FROM todoNote WHERE id = :todoNoteId")
//    override suspend fun getTodoNoteById(todoNoteId: Int): TodoNote?

    @Query("SELECT * FROM todoNote WHERE id = :todoNoteId")
    override suspend fun getTodoNoteById(todoNoteId: Int): TodoNote?
}