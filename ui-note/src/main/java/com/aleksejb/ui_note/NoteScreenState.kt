package com.aleksejb.ui_note

import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.NoteType

data class NoteScreenState(
    val note: NoteDataModel
) {
    companion object {
        val Default = NoteScreenState(
            note = NoteDataModel(
                id = 0,
                noteTitle = "",
                text = "",
                type = NoteType.NOTE
            )
        )
    }
}