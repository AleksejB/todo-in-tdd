package com.example.ui_main_screen

import com.example.data_core.database.entity.TodoNote

data class MainScreenState(
    val notes: List<com.example.data_core.database.entity.TodoNote>
) {
    companion object {
        val Default = MainScreenState(
            notes = emptyList()
        )
    }
}