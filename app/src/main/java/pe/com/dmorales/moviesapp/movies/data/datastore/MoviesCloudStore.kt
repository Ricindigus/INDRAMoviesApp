package pe.com.dmorales.moviesapp.movies.data.datastore

import pe.com.dmorales.moviesapp.core.data.datasource.local.database.entities.MovieEntity
import pe.com.dmorales.moviesapp.core.data.datasource.remote.Result
import pe.com.dmorales.moviesapp.core.utils.apiService
import pe.com.dmorales.moviesapp.movies.data.mappers.asDatabaseModel
import pe.com.dmorales.moviesapp.movies.data.network.api.IMoviesApiService

class MoviesCloudStore(private val moviesApiService: IMoviesApiService){
    suspend fun getMoviesSummaryList(page: Int): Result<Array<MovieEntity>> {
        return apiService {
            val response = moviesApiService.getMoviesSummaryList(page)
            if (response.isSuccessful) {
                val body = response.body()
                val userData = body?.asDatabaseModel()
                success { userData }
            } else
                error { response }
        }
    }
}