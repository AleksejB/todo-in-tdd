package com.example.ui_core.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.example.domain_core.model.Note
import com.example.ui_core.R

@Composable
fun NoteItem(note: Note) {
    Column(
        modifier = Modifier
            .padding(horizontal = dimensionResource(R.dimen.padding_default))
            .fillMaxWidth()
    ) {
        NoteTitleText(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
            noteTitle = note.noteTitle
        )

        NoteTypeText(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
            noteType = note.type.label
        )

        NoteSummary(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
            noteSummary = note.text
        )
    }
}

@Composable
private fun NoteTitleText(
    modifier: Modifier = Modifier,
    noteTitle: String
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = noteTitle,
        textAlign = TextAlign.Start
    )
}

@Composable
private fun NoteTypeText(
    modifier: Modifier = Modifier,
    noteType: String
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = noteType,
        textAlign = TextAlign.Start
    )
}

@Composable
private fun NoteSummary(
    modifier: Modifier = Modifier,
    noteSummary: String
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = noteSummary,
        textAlign = TextAlign.Start,
        maxLines = NOTE_SUMMARY_MAX_LINES
    )
}

private const val NOTE_SUMMARY_MAX_LINES = 2