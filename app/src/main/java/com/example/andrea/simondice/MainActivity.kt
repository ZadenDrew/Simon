package com.example.andrea.simondice

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import org.jetbrains.anko.toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var sec:ArrayList<Int> = ArrayList()
    var secRec:ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        amarillo.setTag("amarillo")
        azul.setTag("azul")
        rojo.setTag("rojo")
        verde.setTag("verde")

        jugar.setOnClickListener {
            genSeq()
            ejeSeq()
        }

        amarillo.setOnClickListener(){
            recSeq(it)
        }
        azul.setOnClickListener(){
            recSeq(it)
        }
        rojo.setOnClickListener(){
            recSeq(it)
        }
        verde.setOnClickListener(){
            recSeq(it)
        }
    }

    fun genSeq(){
        sec.add(1)
    }

    fun ejeSeq(){
        val amarilloOscuro = Color.parseColor("#FFFFBB33")
        val amarilloClaro = Color.parseColor("#FFFFE11E")
        val azulOscuro = Color.parseColor("0382BE")
        val azulClaro = Color.parseColor("04AEFE")
        val rojoOscuro = Color.parseColor("#DF0D03")
        val rojoClaro = Color.parseColor("#FC1106")
        val verdeOscuro = Color.parseColor("#14BE03")
        val verdeClaro = Color.parseColor("#1AFB03")

        for (valor in sec){
            val handler1 = Handler()
            handler1.postDelayed({
                when (valor){
                    1 -> amarillo.setBackgroundColor(amarilloClaro)
                    2 -> azul.setBackgroundColor(azulClaro)
                    3 -> rojo.setBackgroundColor(rojoClaro)
                    4 -> verde.setBackgroundColor(verdeClaro)
                }
            }, 1000)
            val handler2 = Handler()
            handler2.postDelayed({
                when (valor){
                    1 -> amarillo.setBackgroundColor(amarilloOscuro)
                    2 -> azul.setBackgroundColor(azulOscuro)
                    3 -> rojo.setBackgroundColor(rojoOscuro)
                    4 -> verde.setBackgroundColor(verdeOscuro)
                }
            }, 1500)
        }
    }

    fun recSeq(view: View){
        val btn = view as Button

        when (btn.getTag().toString()){
            "amarillo" -> secRec.add(1)
            "azul" -> secRec.add(1)
            "rojo" -> secRec.add(1)
            "verde" -> secRec.add(1)
        }

        compSeq()
    }

    fun compSeq(){
        if (sec.equals(secRec)){
            toast("Secuencia O.K")
        }else{
            toast("Secuencia no O.K")
        }
    }
}