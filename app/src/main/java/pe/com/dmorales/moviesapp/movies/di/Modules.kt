package pe.com.dmorales.moviesapp.movies.di

import org.koin.core.module.Module
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf
import pe.com.dmorales.moviesapp.movies.data.di.dataModule
import pe.com.dmorales.moviesapp.movies.domain.di.domainModule
import pe.com.dmorales.moviesapp.movies.features.di.featuresModule

val moviesModule by lazy {
    listByElementsOf<Module>(dataModule, domainModule, featuresModule)
}