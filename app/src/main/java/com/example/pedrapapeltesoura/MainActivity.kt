package com.example.pedrapapeltesoura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun botaoPapel(view: View){
        val escolhaApp = Random.nextInt(2)
        when(escolhaApp){
            0 -> appEscolha.text = "App escolheu papel"
            1 -> appEscolha.text = "App escolheu pedra"
            2 -> appEscolha.text = "App escolheu tesoura"
        }
        jogadorEscolha.text = "Você escolheu papel"
        when(escolhaApp){
            0 -> resultado.text = "Empate"
            1 -> resultado.text = "Você venceu"
            2 -> resultado.text = "Você perdeu"
        }
    }

    fun botaoPedra(view: View){
        val escolhaApp = Random.nextInt(2)
        when(escolhaApp){
            0 -> appEscolha.text = "App escolheu papel"
            1 -> appEscolha.text = "App escolheu pedra"
            2 -> appEscolha.text = "App escolheu tesoura"
        }
        jogadorEscolha.text = "Você escolheu pedra"
        when(escolhaApp){
            0 -> resultado.text = "Você perdeu"
            1 -> resultado.text = "Empate"
            2 -> resultado.text = "Você venceu"
        }
    }
    fun botaoTesoura(view: View){
        val escolhaApp = Random.nextInt(2)
        when(escolhaApp){
            0 -> appEscolha.text = "App escolheu papel"
            1 -> appEscolha.text = "App escolheu pedra"
            2 -> appEscolha.text = "App escolheu tesoura"
        }
        jogadorEscolha.text = "Você escolheu tesoura"
        when(escolhaApp){
            0 -> resultado.text = "Você ganhou"
            1 -> resultado.text = "Você perdeu"
            2 -> resultado.text = "Empate"
        }
    }
}