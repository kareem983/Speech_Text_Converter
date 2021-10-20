package com.example.speech_textconverter

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.speech_textconverter.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle("")

        textToSpeech = TextToSpeech(applicationContext) { status ->
            if (status != TextToSpeech.ERROR) {
                textToSpeech.language = Locale.UK
            }
        }

        binding.convertBnt.setOnClickListener {
            val toSpeech: String = binding.editText.text.toString()
            if(!toSpeech.isEmpty()) {
                Toast.makeText(this, toSpeech, Toast.LENGTH_LONG).show()
                textToSpeech.speak(toSpeech, TextToSpeech.QUEUE_FLUSH, null)
            }else Toast.makeText(this, "Enter a Text", Toast.LENGTH_SHORT).show()
        }

    }
}