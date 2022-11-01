package com.example.todo_tdd.ui.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.todo_tdd.ui.navigation.AppNavigation

@Composable
internal fun MainApplicationContent() {

    val navController = rememberNavController()

    AppNavigation(navController = navController)
}