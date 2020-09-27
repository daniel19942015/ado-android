package com.example.combustvel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    var valor_gasolina = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Carregar componentes
        // Método que pega objetos
        val seekbar = findViewById<SeekBar>(R.id.seekBar)
        var valorGasolina = findViewById<TextView>(R.id.valorGasolina)
        val resultado = findViewById<TextView>(R.id.resultado)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        // tam seekbar 0 a 10 só trabalha com valores inteiros
        seekbar.max = 1000

        // Definir listener

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                valor_gasolina = p1
                var texto = "R$ "
                texto += formataValor(valor_gasolina/100.0)
                valorGasolina.text = texto
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                resultado.text = "Selecione o valor da gasolina"
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                resultado.text = "Clique em calcular o resultado"
            }

        })

        btnCalcular.setOnClickListener {
            var valorResultado = (valor_gasolina * 0.7)/100.0
            var texto = "Abasteça com alcool se ele custar até: R$ "
            texto += formataValor(valorResultado)

            resultado.text = texto
        }

    }
    // Formatacao
    private fun formataValor(valor: Any): Any? {
        return String.format(Locale.FRANCE, "%.2f", valor)
    }
}