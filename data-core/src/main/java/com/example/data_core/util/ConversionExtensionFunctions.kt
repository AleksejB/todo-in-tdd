package com.example.data_core.util

import com.example.data_core.database.entity.NoteEntity
import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.Note

fun NoteDataModel.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id = id,
        noteTitle = noteTitle,
        text = text,
        type = type
    )
}

fun Note.toNoteDataModel(): NoteDataModel {
    return NoteDataModel(
        id = id,
        noteTitle = noteTitle,
        text = text,
        type = type
    )
}