package com.example.todo_tdd.ui.navigation.components

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

internal fun NavGraphBuilder.addHomeGraph(
    screenComposables: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = Graph.Home.route,
        startDestination = Screen.Main.createRoute(Graph.Home)
    ) {
        screenComposables()
    }
}