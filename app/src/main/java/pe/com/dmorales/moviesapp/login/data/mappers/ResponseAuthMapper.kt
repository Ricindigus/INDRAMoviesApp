package pe.com.dmorales.moviesapp.login.data.mappers

import pe.com.dmorales.moviesapp.login.data.network.response.AuthResponse
import pe.com.dmorales.moviesapp.login.domain.entities.UserData

fun AuthResponse.asDomainModel() =
    UserData(
        idUser = idUser,
        token = token
    )