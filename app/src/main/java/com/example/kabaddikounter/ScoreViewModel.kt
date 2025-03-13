package com.example.kabaddikounter

import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    var scoreA: Int = 0
    var scoreB: Int = 0

    fun incrementScore(isTeamA: Boolean, value: Int = 1) {
        if (isTeamA) {
            scoreA += value
        } else {
            scoreB += value
        }
    }

    fun resetScore() {
        scoreA = 0
        scoreB = 0
    }
}