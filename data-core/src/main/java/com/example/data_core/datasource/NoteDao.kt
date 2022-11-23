package com.example.data_core.datasource

import androidx.room.*
import com.example.data_core.database.entity.NoteEntity
import com.example.domain_core.datasource.NotesLocalDataSource
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao: NotesLocalDataSource<NoteEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insertNote(note: NoteEntity): Long

    @Query("DELETE FROM todoNote WHERE id = :noteId")
    override suspend fun deleteNoteById(noteId: Long)

    @Query("SELECT * FROM todoNote WHERE id = :noteId")
    override fun getNoteById(noteId: Long): Flow<NoteEntity?>

    @Query("SELECT * FROM todoNote")
    override fun getAllNotes(): Flow<List<NoteEntity>>

}