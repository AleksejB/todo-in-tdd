package com.example.todo_tdd.ui.navigation.components

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

internal fun NavGraphBuilder.addMainScreen() {
    composable(route = Screen.Main.createRoute(Graph.Home)) {

    }
}

internal fun NavGraphBuilder.addNoteScreen() {
    composable(route = Screen.Note.createRoute(Graph.Home)) {

    }
}