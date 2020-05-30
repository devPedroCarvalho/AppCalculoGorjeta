package com.projfinalapp.appgorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private var porcentagem = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //listener seekbar
        seekBarId.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                porcentagem = p1
                txtPorcentagem.text = "$porcentagem %"
                calcular()

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

    }

    fun calcular(){

        var valorRecuperado = edtValor.text.toString()

        if (valorRecuperado == null || valorRecuperado == ""){


        }else{

            var valorDigitado = valorRecuperado.toFloat()



            //calcular gorjeta e total
            var gorjeta = valorDigitado * porcentagem/100

            var total = valorDigitado - gorjeta

            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING


            //exibir valor da gorjeta e o total
            txtGorjeta.text = "R$ " + df.format(gorjeta)
            txtTotal.text = "R$ " + df.format(total)

        }

    }

}


