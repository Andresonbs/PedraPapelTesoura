package com.example.pedrapapeltesoura

import com.j256.ormlite.dao.BaseDaoImpl
import com.j256.ormlite.support.ConnectionSource

class DAOUserPreference : BaseDaoImpl<UserPreference, Int> {
    constructor(connectionSource: ConnectionSource?) : super(UserPreference::class.java){
        setConnectionSource(connectionSource)
        initialize()
    }
}