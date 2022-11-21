package com.example.ui_main_screen

import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.Note

data class MainScreenState(
    val notes: List<Note>
) {
    companion object {
        val Default = MainScreenState(
            notes = emptyList()
        )
    }
}