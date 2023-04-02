package com.example.animals

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val exitButton = findViewById<Button>(R.id.exit_button)
        exitButton.setOnClickListener {
            finish() // close the activity and exit the app
        }
    }
}