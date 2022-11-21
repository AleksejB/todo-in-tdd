package com.example.ui_main_screen

import com.example.data_core.model.NoteDataModel

data class MainScreenState(
    val notes: List<NoteDataModel>
) {
    companion object {
        val Default = MainScreenState(
            notes = emptyList()
        )
    }
}