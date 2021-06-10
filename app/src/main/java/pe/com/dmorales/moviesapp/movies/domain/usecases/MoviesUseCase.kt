package pe.com.dmorales.moviesapp.movies.domain.usecases

import androidx.lifecycle.LiveData
import pe.com.dmorales.moviesapp.movies.data.repository.MoviesRepository
import pe.com.dmorales.moviesapp.movies.domain.entities.MovieSummary

class MoviesUseCase(private val moviesRepository: MoviesRepository) {

    suspend fun refreshSummaryList(page: Int) {
        return moviesRepository.refreshSummaryList(page)
    }

    fun getMoviesList(): LiveData<List<MovieSummary>> = moviesRepository.movies
}