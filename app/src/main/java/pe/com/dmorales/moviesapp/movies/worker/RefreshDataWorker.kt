package pe.com.dmorales.moviesapp.movies.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import pe.com.dmorales.moviesapp.movies.data.repository.MoviesRepository
import retrofit2.HttpException

class RefreshDataWorker(context: Context, params : WorkerParameters): CoroutineWorker(context,params), KoinComponent{
    private val moviesRepository: MoviesRepository by inject()
    override suspend fun doWork(): Result {
        return try {
            moviesRepository.refreshSummaryList(1)
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }
}