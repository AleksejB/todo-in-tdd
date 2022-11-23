package com.example.data_core.datasource

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.example.data_core.database.TodoNoteDatabase
import com.example.data_core.database.entity.NoteEntity
import com.example.data_core.rule.TestDispatcherRule
import com.example.domain_core.model.Note
import com.example.domain_core.model.NoteType
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(AndroidJUnit4::class)
class NoteDaoTest {

    private lateinit var database: TodoNoteDatabase
    private lateinit var noteDao: NoteDao

    @get: Rule
    val dispatcherRule = TestDispatcherRule()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, TodoNoteDatabase::class.java).build()
        noteDao = database.noteDao()
    }

    @After
    fun cleanUp() {
        database.close()
    }

    @Test
    fun getNoteById_validId_returnsNote() {
        runTest {
            //Given
            val noteToInsert = NoteEntity(
                id = 0,
                noteTitle = "noteTitle0",
                text = "noteText0",
                type = NoteType.NOTE
            )
            noteDao.insertNote(note = noteToInsert)
            //When
            noteDao.getNoteById(noteId = 0).test {
                //Then
                val note = awaitItem()
                assertEquals(noteToInsert, note)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun getNoteById_EmptyDb_returnsNull() {
        runTest {
            //Given - an empty db
            //When
            noteDao.getNoteById(1).test {
                //Then
                val note = awaitItem()
                assertEquals(null, note)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun getNoteById_nonExistentNoteId_returnsNull() {
        runTest {
            //Given
            val noteEntity = NoteEntity(
                id = 0,
                noteTitle = "noteTitle0",
                text = "noteText0",
                type = NoteType.NOTE
            )
            //When
            noteDao.insertNote(noteEntity)
            noteDao.getNoteById(1).test {
                //Then
                val note = awaitItem()
                assertEquals(null, note)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun getAllNotes_DbNotEmpty_returnsListOfNotes() {
        runTest {
            //Given
            val listOfNotesToInsert = listOf(
                NoteEntity(
                    id = 0,
                    noteTitle = "noteTitle0",
                    text = "noteText0",
                    type = NoteType.NOTE
                ),
                NoteEntity(
                    id = 1,
                    noteTitle = "noteTitle1",
                    text = "noteText1",
                    type = NoteType.TODO
                ),
                NoteEntity(
                    id = 2,
                    noteTitle = "noteTitle2",
                    text = "noteText2",
                    type = NoteType.NOTE
                )
            )
            listOfNotesToInsert.forEach {
                noteDao.insertNote(it)
            }
            //When
            noteDao.getAllNotes().test {
                //Then
                val noteList = awaitItem()
                assertEquals(listOfNotesToInsert, noteList)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }

    @Test
    fun getAllNotes_DbEmpty_returnsEmptyList() {
        runTest {
            //Given - empty db
            //When
            noteDao.getAllNotes().test {
                //Then
                val noteList = awaitItem()
                assertEquals(emptyList<Note>(), noteList)
                cancelAndIgnoreRemainingEvents()
            }
        }
    }
}