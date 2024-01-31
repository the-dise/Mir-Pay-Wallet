package me.thedise.mirpayinvoke.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _timerValue = MutableStateFlow(30)
    private val defaultTimerValue = 30
    private var timerJob: Job? = null
    private val timerValue: StateFlow<Int> = _timerValue.asStateFlow()

    init {
        startTimer()
    }

    fun getTimerValue(): StateFlow<Int> {
        return timerValue
    }

    private fun startTimer() {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_timerValue.value > 0) {
                delay(1000)
                _timerValue.value--
            }
        }
    }

    fun resetTimer() {
        timerJob?.cancel()
        _timerValue.value = defaultTimerValue
        startTimer()
    }
}
