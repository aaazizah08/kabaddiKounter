package com.example.kabaddikounter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kabaddikounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Menghubungkan ViewModel dengan Binding
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Event untuk tombol-tombol
        binding.buttonPlusOneA.setOnClickListener {
            viewModel.incrementScore(true)
        }

        binding.buttonPlusTwoA.setOnClickListener {
            viewModel.incrementScore(true, 2)
        }

        binding.buttonPlusOneB.setOnClickListener {
            viewModel.incrementScore(false)
        }

        binding.buttonPlusTwoB.setOnClickListener {
            viewModel.incrementScore(false, 2)
        }

        binding.buttonReset.setOnClickListener {
            viewModel.resetScore()
        }
    }
}
