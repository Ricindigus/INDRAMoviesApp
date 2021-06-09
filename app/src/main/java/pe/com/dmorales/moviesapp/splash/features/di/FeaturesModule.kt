package pe.com.dmorales.moviesapp.splash.features.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pe.com.dmorales.moviesapp.splash.features.view.SplashViewModel

internal val featuresModule = module {
    viewModel{ SplashViewModel(get()) }
}