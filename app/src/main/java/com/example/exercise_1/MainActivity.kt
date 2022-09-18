package com.example.exercise_1

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number = findViewById<TextView>(R.id.numero)
        var increment = findViewById<Button>(R.id.incrementar)
        var decrement = findViewById<Button>(R.id.decrementar)
        var nextPage = findViewById<Button>(R.id.nextpage)

        var value = intent.extras
        var count : Int = 0
        var count2 = value?.getInt("verify_number")



        //Shared Preferences
        var sharedPreference : SharedPreferences = getSharedPreferences("Salvar", MODE_PRIVATE)
        var sharedPreferenceEditor : SharedPreferences.Editor = sharedPreference.edit()



        number.text = sharedPreference.getString("valor","").toString()
        count2 = sharedPreference.getString("count2","").toString().toIntOrNull()



        if (count2 == 0){
            count = 0

        }
        else{

            var valor = value?.getString("Nome")

            //count = valor.toString().toInt()
            count = sharedPreference.getString("valor","").toString().toInt()
            number.text = count.toString()
        }



        increment.setOnClickListener{
            count++
            number.text = count.toString()
            sharedPreferenceEditor.putString("valor",number.text.toString())
            sharedPreferenceEditor.putString("count2","")
            sharedPreferenceEditor.commit()
        }
        decrement.setOnClickListener{

            if (count>0) {
                count--
                number.text = count.toString()
            }
            sharedPreferenceEditor.putString("valor",number.text.toString())
            sharedPreferenceEditor.putString("count2","")
            sharedPreferenceEditor.commit()
        }

        nextPage.setOnClickListener{

            sharedPreferenceEditor.putString("valor",number.text.toString())
            sharedPreferenceEditor.putString("count2","")
            sharedPreferenceEditor.commit()
            irParaSegundaTela()
        }

    }

    private fun irParaSegundaTela(){

        var segundaTela = Intent(this,SegundaTela::class.java)
        var argNumber = findViewById<TextView>(R.id.numero)

        segundaTela.putExtra("nome",argNumber.text)

        startActivity(segundaTela)
    }
}
