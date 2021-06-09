package pe.com.dmorales.moviesapp.splash.data.di

import org.koin.core.module.Module
import org.koin.dsl.module
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf

private val networkModule = module {}

private val datastoreModule = module {}

private val repositoryModule = module {}

internal val dataModule by lazy {
    listByElementsOf<Module>(networkModule, datastoreModule, repositoryModule)
}