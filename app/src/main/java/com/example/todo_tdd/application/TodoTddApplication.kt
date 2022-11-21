package com.example.todo_tdd.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.coroutineScope

@HiltAndroidApp
class TodoTddApplication: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}