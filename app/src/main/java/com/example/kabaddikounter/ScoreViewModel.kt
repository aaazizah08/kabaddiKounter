package com.example.kabaddikounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel : ViewModel() {

    private val _scoreA = MutableLiveData(0)
    val scoreA: LiveData<Int> = _scoreA

    private val _scoreB = MutableLiveData(0)
    val scoreB: LiveData<Int> = _scoreB

    fun incrementScore(isTeamA: Boolean, value: Int = 1) {
        if (isTeamA) {
            _scoreA.value = (_scoreA.value ?: 0) + value
        } else {
            _scoreB.value = (_scoreB.value ?: 0) + value
        }
    }

    fun resetScore() {
        _scoreA.value = 0
        _scoreB.value = 0
    }
}
