package com.example.data_core.repository

import com.example.data_core.datasource.MockTodoNotesRemoteDataSource
import com.example.data_core.datasource.MockTodoNotesLocalDataSourceEmpty
import com.example.data_core.database.entity.NoteEntity
import com.example.domain_core.repository.NotesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

//@OptIn(ExperimentalCoroutinesApi::class)
//class NotesRepositoryImplTest {
//
//    private lateinit var notesRepository: NotesRepository
//
//    @Before
//    fun setup() {
//        val notesLocalDataSource = MockTodoNotesLocalDataSource()
//        val notesRemoteDataSource = MockTodoNotesRemoteDataSource()
//        notesRepository = NotesRepositoryImpl(notesLocalDataSource, notesRemoteDataSource)
//    }
//
//    @Test
//    fun getNoteById_validIdOf0_returnsNote() {
//        //Given
//
//        //The notesRepository
//        runTest {
//            //When
//            val note = notesRepository.getNoteById(0)
//            //Then
//            assertEquals(NoteEntity(0, "note1"), note)
//        }
//    }
//
//    @Test
//    fun getNoteById_noNoteExists_returnsNull() {
//        runTest {
//            //Given
//            val localDataSource = MockTodoNotesLocalDataSourceEmpty()
//            val remoteDataSource = MockTodoNotesRemoteDataSource()
//            val emptyNotesRepository = NotesRepositoryImpl(localDataSource, remoteDataSource)
//            //When
//            val note = emptyNotesRepository.getNoteById(0)
//            //Then
//            assertEquals(null, note)
//        }
//    }
//
//    @Test
//    fun getNoteById_nonExistentNoteId_returnsNull() {
//        runTest {
//            //Given - notesRepository
//            //When
//            val note = notesRepository.getNoteById(4)
//            //Then
//            assertEquals(null, note)
//        }
//    }
//
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
//}