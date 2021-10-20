package com.example.speech_textconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.speech_textconverter.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(" ")

        binding.goTextToSpeech.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.goSpeechToText.setOnClickListener{
            startActivity(Intent(this, SpeechToTextActivity::class.java))
        }

    }
}