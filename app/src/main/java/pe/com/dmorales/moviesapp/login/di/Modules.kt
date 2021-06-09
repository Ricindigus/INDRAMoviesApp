package pe.com.dmorales.moviesapp.login.di

import org.koin.core.module.Module
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf
import pe.com.dmorales.moviesapp.login.data.di.dataModule
import pe.com.dmorales.moviesapp.login.domain.di.domainModule
import pe.com.dmorales.moviesapp.login.features.di.featuresModule

val loginModule by lazy {
    listByElementsOf<Module>(dataModule, domainModule, featuresModule)
}