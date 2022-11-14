package com.example.data_core.datasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data_core.database.TodoNoteDatabase
import com.example.data_core.database.entity.NoteEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class NoteEntityDaoTest {

    private lateinit var database: TodoNoteDatabase
    private lateinit var todoNoteDao: TodoNoteDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()

        database = Room.inMemoryDatabaseBuilder(context, TodoNoteDatabase::class.java).build()
        todoNoteDao = database.getTodoNoteDao()
    }

    @After
    fun cleanUp() {
        database.close()
    }

    @Test
    fun getTodoNoteById_validId_returnsTodoNote() {
        runTest {
            //Given
            val noteEntity = NoteEntity(id = 0, text = "localNote0")
            todoNoteDao.insertTodoNote(noteEntity = noteEntity)
            //When
            val note = todoNoteDao.getTodoNoteById(todoNoteId = 0)
            //Then
            assertTrue(noteEntity == note)
        }
    }

    @Test
    fun getTodoNoteById_nonExistentTodoNoteIdAndEmptyDb_returnsNull() {
        runTest {
            //Given - an empty db
            //When
            val note = todoNoteDao.getTodoNoteById(1)
            //Then
            assertTrue(note == null)
        }
    }

    @Test
    fun getTodoNoteById_nonExistentTodoNoteIdAndNotEmptyDb_returnsNull() {
        runTest {
            //Given
            val noteEntity = NoteEntity(id = 0, text = "localNote0")
            todoNoteDao.insertTodoNote(noteEntity)
            //Then
            val note = todoNoteDao.getTodoNoteById(1)
            //When
            assertTrue(note == null)
        }
    }

    @Test
    fun getTodoNoteById_invalidTodoNoteIdAndNotEmptyDb_returns() {
        runTest {
            //Given
            val noteEntity = NoteEntity(id = 0, text = "localNote0")
            todoNoteDao.insertTodoNote(noteEntity)
            //Then
            val note = todoNoteDao.insertTodoNote("abc")
            //Benefits of statically typed languages?
        }
    }

}