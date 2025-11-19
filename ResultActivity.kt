package com.example.zabelinaae_01_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val metersTextView = findViewById<TextView>(R.id.metersTextView)
        val resultTextView = findViewById<TextView>(R.id.finalResultTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        val meters = intent.getDoubleExtra("METERS", 0.0)
        val price = intent.getDoubleExtra("PRICE", 0.0)

        metersTextView.text = "${meters} м²"

        val formattedPrice = "%,.0f".format(price).replace(",", " ")
        resultTextView.text = "$formattedPrice руб."

        backButton.setOnClickListener {

            finish()
        }
    }
}