package com.example.data_core.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.data_core.database.entity.NoteEntity
import com.example.domain_core.datasource.NotesLocalDataSource
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao: NotesLocalDataSource<NoteEntity> {
    @Insert
    override suspend fun insertNote(note: NoteEntity)

    @Delete
    override suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM todoNote WHERE id = :noteId")
    override fun getNoteById(noteId: Int): Flow<NoteEntity?>

    @Query("SELECT * FROM todoNote")
    override fun getAllNotes(): Flow<List<NoteEntity>>

}