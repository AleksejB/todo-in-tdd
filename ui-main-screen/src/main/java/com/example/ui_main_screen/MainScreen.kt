package com.example.ui_main_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import com.aleksejb.ui_core.components.NoteItem
import com.aleksejb.ui_core.R
import com.aleksejb.ui_core.util.ComposableLifecycle

@Composable
fun MainScreen(
    navigateToNewNote: () -> Unit,
    navigateToNote: (noteId: Long) -> Unit
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

    ComposableLifecycle { _, event ->
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                viewModel.onResume()
            }
            else -> {}
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
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_default))
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.top_of_screen_offset))
                    .padding(bottom = dimensionResource(id = R.dimen.notes_title_bottom_offset)),
                text = stringResource(id = R.string.notes),
                style = MaterialTheme.typography.h1
            )
            
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.notes.size) { index ->
                    NoteItem(note = state.notes[index]) {
                        eventHandler(MainScreenEvents.OnNoteClicked(it))
                    }
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