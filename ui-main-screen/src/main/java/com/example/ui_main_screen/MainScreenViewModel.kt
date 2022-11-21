package com.example.ui_main_screen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.aleksejb.ui_core.viewmodel.MVIBaseViewModel
import com.example.data_core.model.NoteDataModel
import com.example.domain_core.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import javax.inject.Inject
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val notesRepository: NotesRepository
): MVIBaseViewModel<MainScreenState, MainScreenEvents, MainScreenEffects>() {

    override fun createInitialState() = MainScreenState.Default

    fun onResume() {
        viewModelScope.launch {
            notesRepository.getAllNotes().collect {
                updateNotesInState { copy(notes = it) }
            }
        }
    }

    override fun handleEvent(event: MainScreenEvents) {
        when (event) {
            is MainScreenEvents.OnNewNoteClicked -> {
                postEffect(MainScreenEffects.NavigateToNewNote)
            }
            is MainScreenEvents.OnNoteClicked -> {
                postEffect(MainScreenEffects.NavigateToNote(event.noteId))
            }
        }
    }

    private fun updateNotesInState(action: MainScreenState.() -> MainScreenState) {
        _state.value = _state.value.action()
    }


}