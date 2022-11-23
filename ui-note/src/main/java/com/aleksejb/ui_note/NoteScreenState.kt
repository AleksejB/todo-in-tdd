package com.aleksejb.ui_note

import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.NoteType

data class NoteScreenState(
    val noteTitle: String,
    val noteText: String,
    val noteType: NoteType
) {
    companion object {
        val Default = NoteScreenState(
            noteTitle = "",
            noteText = "",
            noteType = NoteType.NOTE
        )
    }
}