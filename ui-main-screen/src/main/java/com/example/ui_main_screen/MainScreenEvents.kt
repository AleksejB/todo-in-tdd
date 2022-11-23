package com.example.ui_main_screen

sealed interface MainScreenEvents {
    object OnNewNoteClicked: MainScreenEvents
    data class OnNoteClicked(val noteId: Long): MainScreenEvents
}