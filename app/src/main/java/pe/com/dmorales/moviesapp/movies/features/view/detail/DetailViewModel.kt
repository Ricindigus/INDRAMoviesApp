package pe.com.dmorales.moviesapp.movies.features.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.com.dmorales.moviesapp.movies.domain.entities.MovieSummary
import pe.com.dmorales.moviesapp.movies.domain.usecases.MoviesUseCase

class DetailViewModel(private val moviesUseCase: MoviesUseCase): ViewModel() {

    private val _movieData = MutableLiveData<MovieSummary>()
    val movieData: LiveData<MovieSummary>
        get() = _movieData

    fun setMovieData(movieData: MovieSummary) {
        _movieData.value = movieData
    }
}