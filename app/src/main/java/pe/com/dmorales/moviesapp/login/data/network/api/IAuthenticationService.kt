package pe.com.dmorales.moviesapp.login.data.network.api

import pe.com.dmorales.moviesapp.login.data.network.request.AuthRequest
import pe.com.dmorales.moviesapp.login.data.network.response.AuthResponse
import retrofit2.Response


interface IAuthenticationService {
    fun authenticateUser(authRequest: AuthRequest): Response<AuthResponse>
}