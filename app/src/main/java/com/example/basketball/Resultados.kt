package com.example.basketball

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.basketball.databinding.ActivityResultadosBinding

class Resultados : AppCompatActivity() {
    companion object {
        const val PUNTOS_VISITANTE = "puntos_visitante"
        const val PUNTOS_LOCAL = "puntos_local"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityResultadosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val puntosLocal =bundle.getString(PUNTOS_LOCAL)?:"0"
        val puntosVisitante =bundle.getString(PUNTOS_VISITANTE)?:"0"

        binding.txtResultado.setText("$puntosLocal - $puntosVisitante")

        val resta = puntosLocal.toInt() - puntosVisitante.toInt()

        if(resta == 0) {binding.message.setText("¡EMPATADOS!")}
        if(resta > 0) {binding.message.setText("¡FELICIDADES AL EQUIPO LOCAL!")}
        if(resta < 0) {binding.message.setText("¡FELICIDADES AL EQUIPO VISITANTE!")}

    }
}