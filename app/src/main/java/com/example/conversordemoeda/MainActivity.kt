package com.example.conversordemoeda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /*
         *AUTOR DO PROJETO
         *MATRICULA:72201231
         *NUMERO CHAMADA:
         * NOME: LUIS GONZAGA BARBOSA SILVA
        */
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val real = findViewById<EditText>(R.id.editTextText)
        val dolar = findViewById<EditText>(R.id.editTextText2)
        val euro = findViewById<EditText>(R.id.editTextText3)
        val conversor = findViewById<Button>(R.id.button4)


        conversor.setOnClickListener {
            conversor(real,dolar,euro)
        }

    }

    fun conversor (real: EditText, dolar: EditText,euro : EditText   ) {
        val valoremreal = real.text.toString().toFloatOrNull()
        val valoremdolar = dolar.text.toString().toFloatOrNull()
        val valoremeuro = euro.text.toString().toFloatOrNull()
        val convertor = findViewById<TextView>(R.id.textView2)
        val list = ArrayList<String>()

        if (valoremreal != null) {
            val taxadolar: Float = 0.18F
            val taxaeuro: Float = 0.16F

            val valoremdolar = valoremreal * taxadolar
            val valoremeuro = valoremreal * taxaeuro

            list.add("real:$valoremreal".format())
            list.add("dolar:$valoremdolar".format())
            list.add("euro:$valoremeuro".format())
        }
        else if (valoremdolar != null) {
            val taxareal : Float =0.18F
            val taxaeuro : Float = 0.16F

            val valoremreal = valoremdolar / taxareal
            val valoremeuro = valoremdolar * (taxaeuro/taxareal)

            list.add("real:$valoremreal".format())
            list.add("dolar:$valoremdolar".format())
            list.add("euro:$valoremeuro".format())
        }
        else if (valoremeuro != null) {
            val taxareal: Float = 0.16F
            val taxadolar: Float = 0.18F

            val valoremreal = valoremeuro/taxareal
            val valoremdolar = valoremeuro * (taxadolar/taxareal)

            list.add("real:$valoremreal".format())
            list.add("dolar:$valoremdolar".format())
            list.add("euro:$valoremeuro".format())
        }
        val texto = list.joinToString("")
        convertor.text = texto




    }

}