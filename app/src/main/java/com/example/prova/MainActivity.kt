package com.example.prova

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    private lateinit var calculateButton : Button
    private lateinit var buttonWeightRes : Button
    private lateinit var buttonWeigthSum : Button
    private lateinit var buttonAgeRes : Button
    private lateinit var buttonAgeSum : Button
    private lateinit var TextViewWeight : TextView
    private lateinit var TextViewAge : TextView
    private lateinit var SBheight: SeekBar
    private lateinit var TextViewHeight : TextView
    private lateinit var CVFMale : CardView
    private lateinit var CVFemale : CardView




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
        SBheight = findViewById<SeekBar>(R.id.SBheight)
        TextViewHeight = findViewById(R.id.TextViewHeight)
        CVFMale = findViewById(R.id.CVFMale)
        CVFemale = findViewById(R.id.CVFemale)

        var Color = "purple"
        var ColorF = "purple"

        buttonWeightRes.setOnClickListener {
            var pes = TextViewWeight.text.toString().toInt()
            if(pes > 1){
                TextViewWeight.text = (pes - 1).toString()
            }
        }

        buttonWeigthSum.setOnClickListener {
            var pes = TextViewWeight.text.toString().toInt()
            if(pes < 300){
                TextViewWeight.text = (pes + 1).toString()
            }
        }

        buttonAgeRes.setOnClickListener {
            var edat = TextViewAge.text.toString().toInt()
            if( edat > 1){
                TextViewAge.text = (edat - 1).toString()
            }
        }

        buttonAgeSum.setOnClickListener {
            var edat = TextViewAge.text.toString().toInt()
            if( edat <= 100) {
                TextViewAge.text = (edat + 1).toString()
            }
        }

        SBheight.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TextViewHeight.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        CVFMale.setOnClickListener {
            if (Color == "purple") {
                CVFMale.setCardBackgroundColor(getColor(R.color.purple))
                CVFemale.setCardBackgroundColor(getColor(R.color.colorIMC))
                Color = "colorIMC"
                ColorF = "purple"
            }
            else{
                CVFMale.setCardBackgroundColor(getColor(R.color.colorIMC))
                Color = "purple"
            }
        }
        CVFemale.setOnClickListener {
            if (ColorF == "purple") {
                CVFemale.setCardBackgroundColor(getColor(R.color.purple))
                CVFMale.setCardBackgroundColor(getColor(R.color.colorIMC))
                ColorF = "colorIMC"
                Color = "purple"
            }
            else{
                CVFemale.setCardBackgroundColor(getColor(R.color.colorIMC))
                ColorF = "purple"
            }
        }

        calculateButton.setOnClickListener {
            val peso = TextViewWeight.text.toString().toDoubleOrNull()
            val alturaEnMetros = SBheight.progress.toDouble() / 100

            if (peso == null || peso == 0.0 || alturaEnMetros == 0.0) {
                return@setOnClickListener
            }

            val imc = peso / (alturaEnMetros * alturaEnMetros)
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("IMC", imc)
            startActivity(intent)
        }
    }
}