package pe.com.dmorales.moviesapp.splash.domain.usecases

import pe.com.dmorales.moviesapp.core.data.datasource.local.preferences.AuthenticationPreferences


class SplashUseCase(private val userPreferences: AuthenticationPreferences) {
    fun isLogged(): Boolean{
        return userPreferences.logged
    }
}