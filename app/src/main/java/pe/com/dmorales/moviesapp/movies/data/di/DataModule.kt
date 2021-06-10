package pe.com.dmorales.moviesapp.movies.data.di

import org.koin.core.module.Module
import org.koin.dsl.module
import pe.com.dmorales.moviesapp.BuildConfig.BASE_URL
import pe.com.dmorales.moviesapp.core.data.datasource.remote.RetrofitConfig
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf
import pe.com.dmorales.moviesapp.movies.data.datastore.MoviesCloudStore
import pe.com.dmorales.moviesapp.movies.data.network.api.IMoviesApiService
import pe.com.dmorales.moviesapp.movies.data.repository.MoviesRepository

private val networkModule = module {
    single { RetrofitConfig(BASE_URL, get()).createService(IMoviesApiService::class.java) }
}

private val datastoreModule = module {
    single{ MoviesCloudStore(get()) }
}

private val repositoryModule = module {
    single { MoviesRepository(get(),get()) }
}

internal val dataModule by lazy {
    listByElementsOf<Module>(networkModule, datastoreModule, repositoryModule)
}