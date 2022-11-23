package com.aleksejb.ui_note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aleksejb.ui_core.R
import kotlinx.coroutines.flow.collect

@Composable
fun NoteScreen(
    navigateBack: () -> Unit
) {
    val viewModel = hiltViewModel<NoteScreenViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = viewModel.effects) {
        viewModel.effects.collect { effect ->
            when (effect) {
                is NoteScreenEffects.NavigateBack -> {
                    navigateBack()
                }
            }
        }
    }

    NoteScreenContent(
        state = state,
        eventHandler = viewModel::postEvent
    )
}

@Composable
private fun NoteScreenContent(
    state: NoteScreenState,
    eventHandler: (NoteScreenEvents) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_default))
    ) {
        TextField(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.top_of_screen_offset))
                .fillMaxWidth(),
            value = state.noteTitle,
            onValueChange = {
                eventHandler(NoteScreenEvents.OnNoteTitleChanged(it))
            },
            maxLines = 2
        )

        Text(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_default)),
            text = state.noteType.label
        )

        TextField(
            modifier = Modifier
                .padding(vertical = dimensionResource(R.dimen.padding_default))
                .fillMaxWidth(),
            value = state.noteText,
            onValueChange = {
                eventHandler(NoteScreenEvents.OnNoteTextChanged(it))
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Button(
                modifier = Modifier
                    .padding(end = dimensionResource(id = R.dimen.padding_small))
                    .height(48.dp)
                    .weight(1f),
                onClick = { eventHandler(NoteScreenEvents.OnDeleteClicked) }
            ) {
                Text(text = "Delete")
            }

            Button(
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.padding_small))
                    .height(48.dp)
                    .weight(1f),
                onClick = { eventHandler(NoteScreenEvents.OnSaveClicked) }
            ) {
                Text(text = "Save")
            }
        }
    }
}