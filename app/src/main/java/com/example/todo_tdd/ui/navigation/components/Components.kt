package com.example.todo_tdd.ui.navigation.components

sealed class Graph(val route: String) {
    object Home: Graph("home")
}

sealed class Screen(private val route: String) {

    fun createRoute(graph: Graph) = "${graph.route}/$route"

    object Main: Screen("main")
    object Note: Screen("note?noteId={noteId}")
}

