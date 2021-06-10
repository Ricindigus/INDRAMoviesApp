package pe.com.dmorales.moviesapp.movies.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.component.KoinComponent
import pe.com.dmorales.moviesapp.core.data.datasource.local.database.db.AppDatabase
import pe.com.dmorales.moviesapp.movies.data.datastore.MoviesCloudStore
import pe.com.dmorales.moviesapp.movies.data.mappers.asDomainModel
import pe.com.dmorales.moviesapp.movies.domain.entities.MovieSummary
import pe.com.dmorales.moviesapp.core.data.datasource.remote.Result

class MoviesRepository(private val moviesCloudStore: MoviesCloudStore,
                       private val appDatabase: AppDatabase): KoinComponent {
    val movies: LiveData<List<MovieSummary>> = appDatabase.movieDao().getMoviesList().asDomainModel()

    suspend fun refreshSummaryList(page: Int) {
        when (val result = moviesCloudStore.getMoviesSummaryList(page)) {
            is Result.Success -> {
                withContext(Dispatchers.IO){
                    appDatabase.movieDao().insertAll(*result.data!!)
                }
            }
            is Result.Error -> {
                Log.e("MoviesApp","Error al obtener los datos de internet")
            }
        }
    }
}