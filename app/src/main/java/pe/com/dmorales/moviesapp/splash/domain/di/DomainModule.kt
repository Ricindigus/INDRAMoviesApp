package pe.com.dmorales.moviesapp.splash.domain.di

import org.koin.dsl.module
import pe.com.dmorales.moviesapp.splash.domain.usecases.SplashUseCase

internal val domainModule = module {
    factory { SplashUseCase(get()) }
}