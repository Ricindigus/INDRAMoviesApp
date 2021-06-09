package pe.com.dmorales.moviesapp.login.data.network.api

import pe.com.dmorales.moviesapp.login.data.network.request.AuthRequest
import pe.com.dmorales.moviesapp.login.data.network.response.AuthResponse
import retrofit2.Response

class AuthenticationServiceImpl : IAuthenticationService {
    override fun authenticateUser(authRequest: AuthRequest): Response<AuthResponse> {
        return if (authRequest.user == "Admin" && authRequest.password == "Password*123"){
            Response.success(
                AuthResponse(
                idUser = "Admin",
                token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhNGRjNTAyYzhlZmMwM2FkNWE4YjNlYjdmMzhjMTE2OCIsInN1YiI6IjYwNmM4MjE5MWNjNGZmMDA1ODFmMjg4YyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.om9l-jwIzcRMYz2WgYE4nIUrCWin8Esm_0KKDVqtHzY"
            )
            )
        }else {
            Response.error(0,null)
        }
    }
}