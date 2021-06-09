package pe.com.dmorales.moviesapp.login.domain.usecases

import pe.com.dmorales.moviesapp.core.data.datasource.local.preferences.AuthenticationPreferences
import pe.com.dmorales.moviesapp.core.data.datasource.remote.Result
import pe.com.dmorales.moviesapp.login.data.repository.LoginRepository
import pe.com.dmorales.moviesapp.login.domain.entities.UserData

class LoginUseCase(private val loginRepository: LoginRepository,
                   private val authenticationPreferences: AuthenticationPreferences
) {
    suspend fun loginUser(user:String, password:String): Result<UserData> {
        return when (val result = loginRepository.loginUser(user, password)) {
            is Result.Success -> {
                authenticationPreferences.token = result.data?.token
                authenticationPreferences.logged = true
                result
            }
            is Result.Error -> {
                Result.Error(result.exception)
            }
            else -> result
        }
    }
}