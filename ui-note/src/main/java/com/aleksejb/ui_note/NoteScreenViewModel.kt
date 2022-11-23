package com.aleksejb.ui_note

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.aleksejb.ui_core.viewmodel.MVIBaseViewModel
import com.example.data_core.model.NoteDataModel
import com.example.domain_core.model.Note
import com.example.domain_core.model.NoteType
import com.example.domain_core.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    private val notesRepository: NotesRepository,
    savedStateHandle: SavedStateHandle
): MVIBaseViewModel<NoteScreenState, NoteScreenEvents, NoteScreenEffects>() {

    private var noteId = savedStateHandle.get<String>("noteId")?.toLongOrNull()

    override fun createInitialState(): NoteScreenState = NoteScreenState.Default

    init {
        noteId?.let { getNote(it) } ?: run { createNewNote(); noteId?.let { getNote(it) } }
    }

    override fun handleEvent(event: NoteScreenEvents) {
        when (event) {
            is NoteScreenEvents.OnNoteTextChanged -> {
                _state.update { it.copy(noteText = event.text) }
            }
            is NoteScreenEvents.OnNoteTitleChanged -> {
                _state.update { it.copy(noteTitle = event.title) }
            }
            is NoteScreenEvents.OnSaveClicked -> {
                noteId?.let {
                    insertNote(
                        note = NoteDataModel(
                            id = it,
                            noteTitle = state.value.noteTitle,
                            text = state.value.noteText,
                            type = NoteType.NOTE
                        )
                    )
                }
            }
            is NoteScreenEvents.OnDeleteClicked -> {
                viewModelScope.launch {
                    noteId?.let { notesRepository.deleteNoteById(it) }
                    postEffect(NoteScreenEffects.NavigateBack)
                }
            }
        }
    }

    private fun createNewNote() {
        viewModelScope.launch {
            noteId = notesRepository.insertNote(
                note = NoteDataModel(
                    id = 0,
                    noteTitle = "",
                    text = "",
                    NoteType.TODO
                )
            )
        }
    }

    private fun getNote(noteId: Long) {
        viewModelScope.launch {
            notesRepository.getNoteById(noteId).collect { note ->
                note?.let {
                    _state.value = state.value.copy(
                        noteTitle = it.noteTitle,
                        noteText = it.text,
                        noteType = it.type
                    )
                }
            }
        }
    }

    private fun insertNote(note: NoteDataModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                notesRepository.insertNote(note)
            }
        }
    }
}