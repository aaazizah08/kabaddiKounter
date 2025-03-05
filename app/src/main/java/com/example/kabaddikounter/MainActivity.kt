package com.example.kabaddikounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val viewModel: ScoreViewModel by viewModels()

    private lateinit var tvScoreA: TextView
    private lateinit var tvScoreB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvScoreA = findViewById(R.id.scoreA)
        tvScoreB = findViewById(R.id.scoreB)
        val buttonPlusOneA = findViewById<Button>(R.id.buttonPlusOneA)
        val buttonPlusTwoA = findViewById<Button>(R.id.buttonPlusTwoA)
        val buttonPlusOneB = findViewById<Button>(R.id.buttonPlusOneB)
        val buttonPlusTwoB = findViewById<Button>(R.id.buttonPlusTwoB)
        val buttonReset = findViewById<Button>(R.id.buttonReset)

        updateScoreUI()

        buttonPlusOneA.setOnClickListener {
            viewModel.incrementScore(true)
            updateScoreUI()
        }

        buttonPlusTwoA.setOnClickListener {
            viewModel.incrementScore(true)
            viewModel.incrementScore(true)
            updateScoreUI()
        }

        buttonPlusOneB.setOnClickListener {
            viewModel.incrementScore(false)
            updateScoreUI()
        }

        buttonPlusTwoB.setOnClickListener {
            viewModel.incrementScore(false)
            viewModel.incrementScore(false)
            updateScoreUI()
        }

        buttonReset.setOnClickListener {
            viewModel.resetScore()
            updateScoreUI()
        }
    }

    private fun updateScoreUI() {
        tvScoreA.text = viewModel.scoreA.toString()
        tvScoreB.text = viewModel.scoreB.toString()
    }
}