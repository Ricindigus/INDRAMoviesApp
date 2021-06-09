package pe.com.dmorales.moviesapp.core.data.di

import android.content.Context
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module
import pe.com.dmorales.moviesapp.R
import pe.com.dmorales.moviesapp.core.data.datasource.local.database.db.AppDatabase
import pe.com.dmorales.moviesapp.core.data.datasource.local.preferences.AuthenticationPreferences
import pe.com.dmorales.moviesapp.core.utils.listByElementsOf

val preferencesModule = module {
    single { AuthenticationPreferences(get<Context>().authPreferences) }
}

private val Context.authPreferences
    get() = getSharedPreferences(AuthenticationPreferences.PREFERENCES_NAME, Context.MODE_PRIVATE)

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(),
            AppDatabase::class.java,
            androidContext().resources.getString(R.string.database_name))
            .build()
    }
}

internal val dataModule by lazy {
    listByElementsOf<Module>(preferencesModule, databaseModule)
}