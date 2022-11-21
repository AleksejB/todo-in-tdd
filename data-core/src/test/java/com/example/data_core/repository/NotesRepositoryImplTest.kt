package com.example.data_core.repository

import app.cash.turbine.test
import com.example.data_core.database.entity.NoteEntity
import com.example.data_core.fakedatasource.FakeNotesLocalDataSource
import com.example.data_core.fakedatasource.FakeEmptyNotesLocalDataSource
import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.Note
import com.example.domain_core.model.NoteType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NotesRepositoryImplTest {

    @Test
    fun `getNoteById existingId returnsNull`() {
        runTest {
            //Given - noteId = 0
            val notesLocalDataSource = FakeNotesLocalDataSource()
            val notesRepository = NotesRepositoryImpl(notesLocalDataSource)
            //When the getNoteById is called
            notesRepository.getNoteById(0).test {
                //Then
                assertEquals(
                    NoteDataModel(
                        id = 0,
                        noteTitle = "note1",
                        text = "noteText1",
                        type = NoteType.NOTE
                    ), awaitItem()
                )
                awaitComplete()
            }
        }
    }

    @Test
    fun `getNoteById nonExistingId returnsNull`() {
        runTest {
            //Given noteId = -1
            val notesLocalDataSource = FakeNotesLocalDataSource()
            val notesRepository = NotesRepositoryImpl(notesLocalDataSource)
            //When the getNoteById is called
            notesRepository.getNoteById(-1).test {
                //Then
                assertEquals(null, awaitItem())
                awaitComplete()
            }
        }
    }

    @Test
    fun `getNoteById noNoteExists returnsNull`() {
        runTest {
            //Given noteId = 1 and:
            val emptyNotesLocalDataSource = FakeEmptyNotesLocalDataSource()
            val notesRepository = NotesRepositoryImpl(emptyNotesLocalDataSource)
            //When the getNoteById is called
            notesRepository.getNoteById(1).test {
                //Then
                assertEquals(null, awaitItem())
                awaitComplete()
            }
        }
    }

    @Test
    fun `getAllNotes DbNotEmpty returnsListOfNotes`() {
        runTest {
            //Given
            val notesLocalDataSource = FakeNotesLocalDataSource()
            val notesRepository = NotesRepositoryImpl(notesLocalDataSource)
            //When
            notesRepository.getAllNotes().test {
                //Then
                val noteList = awaitItem()
                assertEquals(notesLocalDataSource.noteEntities, noteList)
                awaitComplete()
            }
        }
    }

    @Test
    fun `getAllNotes EmptyDb returnsEmptyList`() {
        runTest {
            //Given
            val emptyNotesLocalDataSource = FakeEmptyNotesLocalDataSource()
            val notesRepository = NotesRepositoryImpl(emptyNotesLocalDataSource)
            //When
            notesRepository.getAllNotes().test {
                //Then
                val noteList = awaitItem()
                assertEquals(emptyList<Note>(), noteList)
                awaitComplete()
            }
        }
    }

//    @Test
//    fun getCombinedNoteTextFromLocalAndRemote_validNoteId_sameNoteTextFromLocalAndRemoteSources_returnsRemoteNoteText() {
//        runTest {
//            //Given - notesRepository
//            //When
//            val text = notesRepository.getCombinedNoteTextFromLocalAndRemote(0)
//            //Then
//            assertEquals("note1", text)
//        }
//    }
//
//    @Test
//    fun getCombinedNoteTextFromLocalAndRemote_validTodoNoteId_differentNoteTextFromLocalAndRemote_returnsCombinedText() {
//        runTest {
//            //Given - notesRepository
//            //When
//            val text = notesRepository.getCombinedNoteTextFromLocalAndRemote(1)
//            //Then
//            assertEquals("note2remoteNote2", text)
//        }
//    }
//
//    @Test
//    fun getCombinedNoteTextFromLocalAndRemote_nonExistentTodoNoteId_returnsNull() {
//        runTest {
//            //Given - notesRepository
//            //When
//            val noteText = notesRepository.getCombinedNoteTextFromLocalAndRemote(10)
//            assertEquals(null, noteText)
//        }
//    }
}