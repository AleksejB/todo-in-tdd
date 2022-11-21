package com.aleksejb.ui_note

import com.aleksejb.ui_core.viewmodel.MVIBaseViewModel
import com.example.domain_core.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
//    private val notesRepository: NotesRepository
): MVIBaseViewModel<NoteScreenState, NoteScreenEvents, NoteScreenEffects>() {
    override fun createInitialState(): NoteScreenState = NoteScreenState.Default

    override fun handleEvent(events: NoteScreenEvents) {

    }
}