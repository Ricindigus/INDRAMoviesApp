package pe.com.dmorales.moviesapp.app

import android.app.Application
import android.os.Build
import androidx.work.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import pe.com.dmorales.moviesapp.app.di.appModules
import pe.com.dmorales.moviesapp.movies.worker.RefreshDataWorker
import java.util.concurrent.TimeUnit

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
        delayedInit()
    }

    private fun delayedInit() = applicationScope.launch {
        setupRecurringWork()
    }

    private fun setupRecurringWork() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .setRequiresCharging(true)
            .apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    setRequiresDeviceIdle(true)
                }
            }.build()

        val repeatingRequest =
            PeriodicWorkRequestBuilder<RefreshDataWorker>(20, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

        WorkManager
            .getInstance()
            .enqueueUniquePeriodicWork(
                RefreshDataWorker.WORK_NAME,
                ExistingPeriodicWorkPolicy.KEEP,
                repeatingRequest)
    }
}