package com.example.ui_core

class NativeLib {

    /**
     * A native method that is implemented by the 'ui_core' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'ui_core' library on application startup.
        init {
            System.loadLibrary("ui_core")
        }
    }
}