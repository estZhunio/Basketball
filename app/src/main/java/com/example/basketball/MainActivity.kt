package com.example.basketball

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.basketball.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1Local.setOnClickListener{ binding.puntosLocal.setText(sumar(binding.puntosLocal.text.toString(), 1)) }
        binding.btn2Local.setOnClickListener{ binding.puntosLocal.setText(sumar(binding.puntosLocal.text.toString(), 2)) }
        binding.btnmn1Local.setOnClickListener{ binding.puntosLocal.setText(sumar(binding.puntosLocal.text.toString(), -1)) }
        binding.btn1Visitante.setOnClickListener{ binding.puntosVisitante.setText(sumar(binding.puntosVisitante.text.toString(), 1)) }
        binding.btn2Visitante.setOnClickListener{ binding.puntosVisitante.setText(sumar(binding.puntosVisitante.text.toString(), 2)) }
        binding.btnmn1Visitante.setOnClickListener{ binding.puntosVisitante.setText(sumar(binding.puntosVisitante.text.toString(), -1)) }

        binding.reiniciar.setOnClickListener{ clear() }

        binding.pasarPuntos.setOnClickListener{ terminar(binding.puntosLocal.text.toString(), binding.puntosVisitante.text.toString()) }

    }



    fun sumar(valor: String, incremento: Int): String {
        val num = (valor.toInt() + incremento)
        return (if (num > 0) num else 0).toString()
    }

    fun terminar(puntosLocal: String, puntosVisitante: String) {
        val intent = Intent (this, Resultados::class.java)
        intent.putExtra(Resultados.PUNTOS_LOCAL, puntosLocal)
        intent.putExtra(Resultados.PUNTOS_VISITANTE, puntosVisitante)

        startActivity(intent)
    }

    fun clear() {
        binding.puntosLocal.setText("0")
        binding.puntosVisitante.setText("0")
    }





}