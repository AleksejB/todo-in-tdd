package com.example.data_core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data_core.datasource.TodoNoteDao
import com.example.data_core.database.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class TodoNoteDatabase: RoomDatabase() {
    abstract fun getTodoNoteDao(): TodoNoteDao

    companion object {
        private const val DB_NAME = "TodoNote.db"

        @Volatile
        private var instance: TodoNoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TodoNoteDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }
}