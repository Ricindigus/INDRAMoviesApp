package pe.com.dmorales.moviesapp.movies.domain.usecases

import pe.com.dmorales.moviesapp.core.data.datasource.local.preferences.AuthenticationPreferences

class SessionUseCase(private val userPreferences: AuthenticationPreferences) {
    fun closeSession(){
        userPreferences.clear()
    }
}