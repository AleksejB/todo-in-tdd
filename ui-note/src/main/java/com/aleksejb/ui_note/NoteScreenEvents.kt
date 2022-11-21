package com.aleksejb.ui_note

sealed interface NoteScreenEvents {
    data class OnNoteTitleChanged(val title: String): NoteScreenEvents
    data class OnNoteTextChanged(val text: String): NoteScreenEvents
}