package pe.com.dmorales.moviesapp.splash.di

import org.koin.core.module.Module
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf
import pe.com.dmorales.moviesapp.splash.data.di.dataModule
import pe.com.dmorales.moviesapp.splash.domain.di.domainModule
import pe.com.dmorales.moviesapp.splash.features.di.featuresModule

val splashModule by lazy {
    listByElementsOf<Module>(dataModule, domainModule, featuresModule)
}