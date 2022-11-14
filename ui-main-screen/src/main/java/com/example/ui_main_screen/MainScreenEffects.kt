package com.example.ui_main_screen

sealed interface MainScreenEffects {
    object NavigateToNewNote: MainScreenEffects
    data class NavigateToNote(val noteId: Int): MainScreenEffects
}