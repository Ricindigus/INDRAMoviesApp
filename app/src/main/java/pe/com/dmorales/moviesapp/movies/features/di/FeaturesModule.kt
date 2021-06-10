package pe.com.dmorales.moviesapp.movies.features.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pe.com.dmorales.moviesapp.movies.features.view.detail.DetailViewModel
import pe.com.dmorales.moviesapp.movies.features.view.main.MainViewModel
import pe.com.dmorales.moviesapp.movies.features.view.movies.MoviesViewModel

internal val featuresModule = module {
    viewModel{ MoviesViewModel(get()) }
    viewModel{ DetailViewModel(get()) }
    viewModel { MainViewModel(get()) }
}