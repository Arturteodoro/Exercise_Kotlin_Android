package com.example.exercise_1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaTela : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        var backPage = findViewById<Button>(R.id.back)
        var result = findViewById<TextView>(R.id.ResultadoFinal)

        var value = intent.extras
        var valor = value?.getString("nome")



        result.text = (valor)

        backPage.setOnClickListener{
            IrParaPrimeiraTela()
        }
    }
    private fun IrParaPrimeiraTela(){

        var primeiraTela = Intent(this,MainActivity::class.java)
        var argNumber = findViewById<TextView>(R.id.ResultadoFinal)

        primeiraTela.putExtra("Nome",argNumber.text)
        primeiraTela.putExtra("verify_number",1)
        startActivity(primeiraTela)


    }
}