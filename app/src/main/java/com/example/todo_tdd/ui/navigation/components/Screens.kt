package com.example.todo_tdd.ui.navigation.components

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aleksejb.ui_note.NoteScreen
import com.example.ui_main_screen.MainScreen

internal fun NavGraphBuilder.addMainScreen(navController: NavController) {
    composable(route = Screen.Main.createRoute(Graph.Home)) {
        MainScreen(
            navigateToNote = { noteId ->
                navController.navigate("home/note?noteId=$noteId")
            },
            navigateToNewNote = {
                navController.navigate(Screen.Note.createRoute(Graph.Home))
            }
        )
    }
}

internal fun NavGraphBuilder.addNoteScreen(navController: NavController) {
    composable(
        route = Screen.Note.createRoute(Graph.Home),
        arguments = listOf(
            navArgument("noteId") {
                nullable = true
                defaultValue = null
                type = NavType.StringType
            }
        )
    ) {
        NoteScreen { navController.navigateUp() }
    }
}