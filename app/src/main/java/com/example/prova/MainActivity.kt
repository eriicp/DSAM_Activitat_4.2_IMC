package com.example.prova

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var calculateButton : Button
    private lateinit var buttonWeightRes : Button
    private lateinit var buttonWeigthSum : Button
    private lateinit var buttonAgeRes : Button
    private lateinit var buttonAgeSum : Button
    private lateinit var TextViewWeight : TextView
    private lateinit var TextViewAge : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculateButton = findViewById(R.id.calculateButton)
        buttonWeightRes = findViewById(R.id.buttonWeightRes)
        buttonWeigthSum = findViewById(R.id.buttonWeigthSum)
        buttonAgeRes = findViewById(R.id.buttonAgeRes)
        buttonAgeSum = findViewById(R.id.buttonAgeSum)
        TextViewAge = findViewById(R.id.TextViewAge)
        TextViewWeight = findViewById(R.id.TextViewWeight)




        calculateButton.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("nom", "Giovanni")
            startActivity(intent)
        }

        buttonWeightRes.setOnClickListener {
            TextViewWeight.text = (TextViewWeight.text.toString().toInt() - 1).toString()
        }

        buttonWeigthSum.setOnClickListener {
            TextViewWeight.text = (TextViewWeight.text.toString().toInt() + 1).toString()
        }

        buttonAgeRes.setOnClickListener {
            TextViewAge.text = (TextViewAge.text.toString().toInt() - 1).toString()
        }

        buttonAgeSum.setOnClickListener {
            TextViewAge.text = (TextViewAge.text.toString().toInt() + 1).toString()
        }

    }
}