package pe.com.dmorales.moviesapp.core.di

import org.koin.core.module.Module
import pe.com.dmorales.moviesapp.core.data.di.dataModule
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf

val coreModule by lazy {
    listByElementsOf<Module>(dataModule)
}