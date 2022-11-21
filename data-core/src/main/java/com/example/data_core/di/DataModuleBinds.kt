package com.example.data_core.di

import com.example.data_core.database.entity.NoteEntity
import com.example.data_core.datasource.NoteDao
import com.example.data_core.model.NoteDataModel
import com.example.data_core.repository.NotesRepositoryImpl
import com.example.domain_core.datasource.NotesLocalDataSource
import com.example.domain_core.model.Note
import com.example.domain_core.repository.NotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModuleBinds {

    @Binds
    abstract fun bindNotesLocalDataSource(noteDao: NoteDao): NotesLocalDataSource<NoteEntity>

    @Binds
    abstract fun bindNotesRepository(notesRepositoryImpl: NotesRepositoryImpl): NotesRepository
}