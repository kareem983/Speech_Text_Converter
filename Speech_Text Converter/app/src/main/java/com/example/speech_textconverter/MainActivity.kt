package com.example.speech_textconverter

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var t1:TextToSpeech
    lateinit var textInput:EditText
    lateinit var convertBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textInput = findViewById(R.id.edit_text)
        convertBtn = findViewById(R.id.convert_bnt)

        t1 = TextToSpeech(applicationContext) { status ->
            if (status != TextToSpeech.ERROR) {
                t1.language = Locale.UK
            }
        }

        convertBtn.setOnClickListener {
            val toSpeech: String = textInput.text.toString()
            if(!toSpeech.isEmpty()) {
                Toast.makeText(this, toSpeech, Toast.LENGTH_LONG).show()
                t1.speak(toSpeech, TextToSpeech.QUEUE_FLUSH, null)
            }else Toast.makeText(this, "Enter a Text", Toast.LENGTH_SHORT).show()
        }

    }
}