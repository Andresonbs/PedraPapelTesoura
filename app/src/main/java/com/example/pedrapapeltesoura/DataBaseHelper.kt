package com.example.pedrapapeltesoura

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

class DataBaseHelper : OrmLiteSqliteOpenHelper {

    companion object {
        private val db = "UserPreference.db"
        private val versao = 1
    }

    constructor(context: Context) : super(context,db,null,versao)

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        //Cria a tabela
        // O primeiro campo é a conexão e o segundo é a classe que serã persistida no banco de dados
        TableUtils.createTable(connectionSource,UserPreference::class.java)

    }

    override fun onUpgrade(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: Int, newVersion: Int) {}

    override fun close() {
        super.close()
    }
}