package com.example.kabaddikounter

import androidx.lifecycle.ViewModel

class ScoreViewModel:ViewModel() {
    var scoreA: Int = 0
    var scoreB: Int = 0

    fun incrementScore(isTeamA: Boolean){
        if (isTeamA) {
            scoreA++
        } else {
            scoreB++
        }
    }
}