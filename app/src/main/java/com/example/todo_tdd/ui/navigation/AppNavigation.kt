package com.example.todo_tdd.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.todo_tdd.ui.navigation.components.*
import com.example.todo_tdd.ui.navigation.components.addHomeGraph
import com.example.todo_tdd.ui.navigation.components.addMainScreen

@Composable
internal fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Graph.Home.route
    ) {
        addHomeGraph {
            addMainScreen(navController)
            addNoteScreen(navController)
        }
    }
}