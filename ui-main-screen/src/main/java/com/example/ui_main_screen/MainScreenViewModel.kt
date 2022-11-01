package com.example.ui_main_screen

import com.example.ui_core.baseviewmodel.MVIBaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(

): MVIBaseViewModel<MainScreenState, MainScreenEvents, MainScreenEffects>() {

    override fun createInitialState() = MainScreenState.Default

    override fun handleEvent(events: MainScreenEvents) {

    }

}