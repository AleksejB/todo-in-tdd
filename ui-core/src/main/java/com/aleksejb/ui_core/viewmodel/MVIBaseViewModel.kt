package com.aleksejb.ui_core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class MVIBaseViewModel<State, Events, Effects>(): ViewModel() {

    abstract fun createInitialState(): State

    private val _effects: Channel<Effects> = Channel()
    val effects get() = _effects.receiveAsFlow()

    private val _events: MutableSharedFlow<Events> = MutableSharedFlow()
    val events get() = _events.asSharedFlow()

    private val _state: MutableStateFlow<State> = MutableStateFlow(createInitialState())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            events.collect {
                handleEvent(it)
            }
        }
    }

    protected abstract fun handleEvent(events: Events)

    fun postEvent(events: Events) {
        viewModelScope.launch { _events.emit(events) }
    }

    protected fun postEffect(effects: Effects) {
        viewModelScope.launch { _effects.send(effects) }
    }
}