package pe.com.dmorales.moviesapp.login.domain.di

import org.koin.dsl.module
import pe.com.dmorales.moviesapp.login.domain.usecases.LoginUseCase

internal val domainModule = module {
    factory { LoginUseCase(get(),get()) }
}