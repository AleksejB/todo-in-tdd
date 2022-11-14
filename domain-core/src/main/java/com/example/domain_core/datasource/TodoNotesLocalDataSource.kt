package com.example.domain_core.datasource

interface TodoNotesLocalDataSource {
    suspend fun getTodoNoteById(noteId: Int): NoteEntity?
    suspend fun insertTodoNote(note: NoteEntity)
    suspend fun deleteTodoNote(note: NoteEntity)

    //domain should be able to map to entity and back :
    //  - entity in domain
    //  - interfaces for domain models
}