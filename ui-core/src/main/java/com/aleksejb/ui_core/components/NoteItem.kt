package com.aleksejb.ui_core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.aleksejb.ui_core.R
import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.Note

@Composable
fun NoteItem(
    note: Note,
    onNoteClicked: (noteId: Long) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onNoteClicked(note.id) }
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