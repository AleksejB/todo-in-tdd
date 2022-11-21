package com.aleksejb.ui_note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.aleksejb.ui_core.R

@Composable
fun NoteScreen(
    navigateBack: () -> Unit
) {
    val viewModel = hiltViewModel<NoteScreenViewModel>()
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = viewModel.effects) {

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
            value = state.note.noteTitle,
            onValueChange = {
                eventHandler(NoteScreenEvents.OnNoteTitleChanged(it))
            },
            maxLines = 2
        )

        Text(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_default)),
            text = state.note.type.label
        )

        TextField(
            modifier = Modifier
                .padding(top = dimensionResource(R.dimen.padding_default))
                .fillMaxSize(),
            value = state.note.text,
            onValueChange = {
                eventHandler(NoteScreenEvents.OnNoteTextChanged(it))
            }
        )
    }
}