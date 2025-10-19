package com.github.nazaburo.sharedkoinviewmodelsample.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var inputText by mutableStateOf("")
        private set

    fun updateText(newText: String) {
        inputText = newText
    }
}