package com.example.data_core.repository

import com.example.data_core.datasource.MockNotesLocalDataSource
import com.example.data_core.datasource.MockNotesLocalDataSourceEmpty
import com.example.domain_core.model.Note
import com.example.domain_core.repository.NotesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class NotesRepositoryImplTest {

    private lateinit var notesRepository: NotesRepository

    @Before
    fun setup() {
        val notesLocalDataSource = MockNotesLocalDataSource()
        notesRepository = NotesRepositoryImpl(notesLocalDataSource)
    }

    @Test
    fun getNoteById_validIdOf0_returnsNote() {
        //Given
        //The notesRepository
        runTest {
            //When
            val note = notesRepository.getNoteById(0)
            //Then
            assertEquals(Note(0, "note1"), note)
        }
    }

    //Ok, this testing seems pointless and stupid. I am testing the logic in the mock data source
    //instead of any production code
    //Ill write db tests now instead, because then, I can do integration tests which will test something
    //but then there are no unit tests which should be required to test the repository later in integration tests



    @Test
    fun getNoteById_noNoteExists_returnsNull() {
        runTest {
            //Given
            val localDataSource = MockNotesLocalDataSourceEmpty()
            val noteRepository = NotesRepositoryImpl(localDataSource)
            //When
            val note = noteRepository.getNoteById(0)
            //Then
            assertEquals(null, note)
        }
    }

    @Test
    fun getNoteById_nonExistentNoteId_returnsNull() {
        runTest {
            //Given - notesRepository
            //When
            val note = notesRepository.getNoteById(4)
            //Then
            assertEquals(null, note)
        }
    }

    @Test
    fun getNoteById_invalidNoteId_returns


}