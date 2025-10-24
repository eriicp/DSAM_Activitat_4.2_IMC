package com.example.prova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    lateinit var TextViewNumResultado : TextView
    lateinit var backBtnSucces : ImageButton
    lateinit var TextViewClase : TextView
    lateinit var TextViewClase2 : TextView
    lateinit var ReCalcBtn : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        TextViewNumResultado = findViewById(R.id.TextViewNumResultado)
        backBtnSucces = findViewById(R.id.backBtnSucces)
        TextViewClase = findViewById(R.id.TextViewClase)
        TextViewClase2 = findViewById(R.id.TextViewClase2)
        ReCalcBtn = findViewById(R.id.ReCalcBtn)


        val imcValue = intent.getDoubleExtra("IMC", 0.0)


        val imcFormateado = String.format("%.1f", imcValue)
        TextViewNumResultado.text = imcFormateado

        if (imcValue < 18.5) {
            TextViewClase.text = "BAIX PES"
            TextViewClase2.text = "El teu pes és més baix del normal."
            TextViewClase.setTextColor(getColor(R.color.blue))
        } else if (imcValue < 25) {
            TextViewClase.text = "NORMAL"
            TextViewClase2.text = "Estàs en un rang de pes saludable."
            TextViewClase.setTextColor(getColor(R.color.green))
        } else if (imcValue < 30) {
            TextViewClase.text = "SOBREPÈS"
            TextViewClase.setTextColor(getColor(R.color.yellow))
            TextViewClase2.text = "El teu pes és superior al normal."
        } else {
            TextViewClase.text = "OBESITAT"
            TextViewClase.setTextColor(getColor(R.color.red))
            TextViewClase2.text = "Estàs en un rang d'obesitat."
        }


        backBtnSucces.setOnClickListener {
            finish()
        }
        ReCalcBtn.setOnClickListener {
            finish()
        }
    }
}