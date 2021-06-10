package pe.com.dmorales.moviesapp.app.di

import org.koin.core.module.Module
import pe.com.dmorales.moviesapp.core.di.coreModule
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf
import pe.com.dmorales.moviesapp.login.di.loginModule
import pe.com.dmorales.moviesapp.movies.di.moviesModule
import pe.com.dmorales.moviesapp.splash.di.splashModule


internal val appModules by lazy {
    listByElementsOf<Module>(
        coreModule, splashModule, loginModule, moviesModule
    )
}