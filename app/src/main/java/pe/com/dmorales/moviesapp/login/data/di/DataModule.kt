package pe.com.dmorales.moviesapp.login.data.di

import org.koin.core.module.Module
import org.koin.dsl.module
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf
import pe.com.dmorales.moviesapp.login.data.datastore.FakeLoginCloudStore
import pe.com.dmorales.moviesapp.login.data.network.api.AuthenticationServiceImpl
import pe.com.dmorales.moviesapp.login.data.network.api.IAuthenticationService
import pe.com.dmorales.moviesapp.login.data.repository.LoginRepository

private val networkModule = module {
    single<IAuthenticationService> { AuthenticationServiceImpl() }
}

private val datastoreModule = module {
    single { FakeLoginCloudStore(get()) }
}

private val repositoryModule = module {
    single { LoginRepository(get()) }
}

internal val dataModule by lazy {
    listByElementsOf<Module>(networkModule, datastoreModule, repositoryModule)
}