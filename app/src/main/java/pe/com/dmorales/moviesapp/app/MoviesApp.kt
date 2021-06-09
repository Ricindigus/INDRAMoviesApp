package pe.com.dmorales.moviesapp.app

import android.app.Application
import androidx.work.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import pe.com.dmorales.moviesapp.app.di.appModules

class MoviesApp : Application() {
    private val applicationScope = CoroutineScope(Dispatchers.Default)

    companion object {
        private lateinit var instance: MoviesApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin {
            androidLogger()
            androidContext(this@MoviesApp)
            modules(appModules)
        }
    }
}