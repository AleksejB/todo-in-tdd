package com.example.ui_main_screen

data class MainScreenState(
    val a: String
) {
    companion object {
        val Default = MainScreenState(
            a = ""
        )
    }
}