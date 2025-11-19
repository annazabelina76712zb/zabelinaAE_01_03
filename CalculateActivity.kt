package com.example.zabelinaae_01_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val metersEditText = findViewById<EditText>(R.id.metersEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val metersText = metersEditText.text.toString()

            if (metersText.isNotEmpty()) {
                try {
                    val meters = metersText.toDouble()


                    val pricePerMeter = 50000.0 // цена за 1 м²
                    val totalPrice = meters * pricePerMeter


                    val formattedResult = "%,.0f".format(totalPrice).replace(",", " ")

                    resultTextView.text = "$formattedResult руб."


                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("METERS", meters)
                    intent.putExtra("PRICE", totalPrice)
                    startActivity(intent)

                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Введите корректное число", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Введите количество метров", Toast.LENGTH_SHORT).show()
            }
        }
    }
}