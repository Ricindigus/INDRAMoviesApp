package pe.com.dmorales.moviesapp.login.features.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pe.com.dmorales.moviesapp.login.features.view.LoginViewModel

internal val featuresModule = module {
    viewModel{ LoginViewModel(get()) }
}