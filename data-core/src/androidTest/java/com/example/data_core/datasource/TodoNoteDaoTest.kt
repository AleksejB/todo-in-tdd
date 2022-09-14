package com.example.data_core.datasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.data_core.database.TodoNoteDatabase
import com.example.domain_core.model.TodoNote
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class TodoNoteDaoTest {

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
            val todoNote = TodoNote(id = 0, text = "localNote0")
            todoNoteDao.insertTodoNote(todoNote = todoNote)
            //When
            val note = todoNoteDao.getTodoNoteById(todoNoteId = 0)
            //Then
            assertTrue(todoNote == note)
        }
    }

    @Test
    fun getTodoNoteById_nonExistentTodoNoteId_returnsNull() {
        runTest {
            //Given - an empty db
            //When
            val note = todoNoteDao.getTodoNoteById(1)
            //Then
            assertTrue(note == null)
        }
    }

}