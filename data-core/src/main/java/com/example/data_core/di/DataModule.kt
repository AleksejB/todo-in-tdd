package com.example.data_core.di

import android.content.Context
import androidx.room.Room
import com.example.data_core.database.TodoNoteDatabase
import com.example.data_core.datasource.NoteDao
import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNotesDatabase(@ApplicationContext context: Context): TodoNoteDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            TodoNoteDatabase::class.java,
            "Notes.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideNotesDao(db: TodoNoteDatabase): NoteDao {
        return db.noteDao()
    }
}