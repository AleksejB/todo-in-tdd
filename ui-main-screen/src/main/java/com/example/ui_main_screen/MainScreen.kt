package com.example.ui_main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.aleksejb.ui_core.components.NoteItem
import com.aleksejb.ui_core.R

@Composable
fun MainScreen(
    navigateToNewNote: () -> Unit,
    navigateToNote: (noteId: Int) -> Unit
) {
    val viewModel = hiltViewModel<MainScreenViewModel>()
    val state by viewModel.state.collectAsState()
    
    LaunchedEffect(key1 = viewModel.effects) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is MainScreenEffects.NavigateToNewNote -> {
                    navigateToNewNote()
                }
                is MainScreenEffects.NavigateToNote -> {
                    navigateToNote(effect.noteId)
                }
            }
        }
    }

    MainScreenContent(state = state, eventHandler = viewModel::postEvent)
}

@Composable
private fun MainScreenContent(
    state: MainScreenState,
    eventHandler: (MainScreenEvents) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.notes.size) { index ->
                    NoteItem(note = state.notes[index])
                }
            }
        }

        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            onClick = { eventHandler(MainScreenEvents.OnNewNoteClicked) }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_iconmonstr_plus_2),
                contentDescription = null 
            )
        }
    }
}