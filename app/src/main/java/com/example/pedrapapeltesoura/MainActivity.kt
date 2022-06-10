package com.example.pedrapapeltesoura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import kotlin.random.Random
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dbHelper: DataBaseHelper = DataBaseHelper(this)
    var dao: DAOUserPreference = DAOUserPreference(dbHelper.connectionSource)
    var isComputador2Activated = true
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            isComputador2Activated = dao.last().activatedComputer2
        }catch (E : Exception){
            isComputador2Activated = true
        }
        appEscolha2.isVisible = isComputador2Activated
        toggleButton.isChecked = isComputador2Activated
    }

    fun onToggleClick(view: View){
        isComputador2Activated = toggleButton.isChecked
        appEscolha2.isVisible = isComputador2Activated
        val userPreference = UserPreference(isComputador2Activated)
        val value = dao.create(userPreference) // armazena no banco de dados
        if (value == 1) {
            Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Falha no registo", Toast.LENGTH_LONG).show()
        }
    }

    fun botaoPapel(view: View){
        val escolhaApp = Random.nextInt(2)
        val escolhaApp2 = Random.nextInt(2)
        when(escolhaApp){
            0 -> appEscolha1.text = "Computador 1 escolheu papel"
            1 -> appEscolha1.text = "Computador 1 escolheu pedra"
            2 -> appEscolha1.text = "Computador 1 escolheu tesoura"
        }
        when(escolhaApp2){
            0 -> appEscolha2.text = "Computador 2 escolheu papel"
            1 -> appEscolha2.text = "Computador 2 escolheu pedra"
            2 -> appEscolha2.text = "Computador 2 escolheu tesoura"
        }
        jogadorEscolha.text = "Você escolheu papel"
        if (isComputador2Activated) {
            when(escolhaApp){
                0 -> when (escolhaApp2){
                    0 -> resultado.text = "Empate"
                    1 -> resultado.text = "Empate"
                    2 -> resultado.text = "Computador 2 venceu"
                }
                1 -> when (escolhaApp2){
                    0 -> resultado.text = "Empate"
                    1 -> resultado.text = "Você venceu"
                    2 -> resultado.text = "Empate"
                }
                2 -> when (escolhaApp2){
                    0 -> resultado.text = "Computador 1 venceu"
                    1 -> resultado.text = "Empate"
                    2 -> resultado.text = "Empate"
                }
            }
        } else{
            when(escolhaApp){
                0 -> resultado.text = "Empate"
                1 -> resultado.text = "Você venceu"
                2 -> resultado.text = "Você perdeu"
            }
        }
    }

    fun botaoPedra(view: View){
        val escolhaApp = Random.nextInt(2)
        val escolhaApp2 = Random.nextInt(2)
        when(escolhaApp){
            0 -> appEscolha1.text = "Computador 1 escolheu papel"
            1 -> appEscolha1.text = "Computador 1 escolheu pedra"
            2 -> appEscolha1.text = "Computador 2 escolheu tesoura"
        }
        when(escolhaApp2){
            0 -> appEscolha2.text = "Computador 2 escolheu papel"
            1 -> appEscolha2.text = "Computador 2 escolheu pedra"
            2 -> appEscolha2.text = "Computador 2 escolheu tesoura"
        }
        jogadorEscolha.text = "Você escolheu pedra"
        if (isComputador2Activated) {
            when(escolhaApp){
                0 -> when (escolhaApp2){
                    0 -> resultado.text = "Empate"
                    1 -> resultado.text = "Computador 1 venceu"
                    2 -> resultado.text = "Empate"
                }
                1 -> when (escolhaApp2){
                    0 -> resultado.text = "Computador 2 venceu"
                    1 -> resultado.text = "Empate"
                    2 -> resultado.text = "Empate"
                }
                2 -> when (escolhaApp2){
                    0 -> resultado.text = "Empate"
                    1 -> resultado.text = "Empate"
                    2 -> resultado.text = "Você venceu"
                }
            }
        } else{
            when(escolhaApp){
                0 -> resultado.text = "Você perdeu"
                1 -> resultado.text = "Empate"
                2 -> resultado.text = "Você venceu"
            }
        }
    }

    fun botaoTesoura(view: View){
        val escolhaApp = Random.nextInt(2)
        val escolhaApp2 = Random.nextInt(2)
        when(escolhaApp){
            0 -> appEscolha1.text = "Computador 1 escolheu papel"
            1 -> appEscolha1.text = "Computador 1 escolheu pedra"
            2 -> appEscolha1.text = "Computador 2 escolheu tesoura"
        }
        when(escolhaApp2){
            0 -> appEscolha2.text = "Computador 2 escolheu papel"
            1 -> appEscolha2.text = "Computador 2 escolheu pedra"
            2 -> appEscolha2.text = "Computador 2 escolheu tesoura"
        }
        jogadorEscolha.text = "Você escolheu tesoura"
        if (isComputador2Activated) {
            when(escolhaApp){
                0 -> when (escolhaApp2){
                    0 -> resultado.text = "Você venceu"
                    1 -> resultado.text = "Empate"
                    2 -> resultado.text = "Empate"
                }
                1 -> when (escolhaApp2){
                    0 -> resultado.text = "Empate"
                    1 -> resultado.text = "Computador 1 venceu"
                    2 -> resultado.text = "Empate"
                }
                2 -> when (escolhaApp2){
                    0 -> resultado.text = "Computador 2 venceu"
                    1 -> resultado.text = "Empate"
                    2 -> resultado.text = "Empate"
                }
            }
        } else{
            when(escolhaApp){
                0 -> resultado.text = "Você ganhou"
                1 -> resultado.text = "Você perdeu"
                2 -> resultado.text = "Empate"
            }
        }
    }

}

@DatabaseTable(tableName = "UserPreference")
class UserPreference{
    @DatabaseField(generatedId = true)
    private var id: Int = 0
    @DatabaseField(columnName = "activatedComputer2")
    var activatedComputer2 : Boolean = false

    constructor()
    constructor(activatedComputer2 : Boolean){
        this.activatedComputer2 = activatedComputer2
    }
}

