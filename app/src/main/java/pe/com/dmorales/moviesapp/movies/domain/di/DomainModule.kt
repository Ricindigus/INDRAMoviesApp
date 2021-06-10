package pe.com.dmorales.moviesapp.movies.domain.di

import org.koin.dsl.module
import pe.com.dmorales.moviesapp.movies.domain.usecases.MoviesUseCase
import pe.com.dmorales.moviesapp.movies.domain.usecases.SessionUseCase

internal val domainModule = module {
    factory { MoviesUseCase(get()) }
    factory { SessionUseCase(get()) }
}