package pe.com.dmorales.moviesapp.movies.features.view.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pe.com.dmorales.moviesapp.movies.domain.entities.MovieSummary
import pe.com.dmorales.moviesapp.movies.domain.usecases.MoviesUseCase

class MoviesViewModel(private val moviesUseCase: MoviesUseCase): ViewModel() {
    val moviesList = moviesUseCase.getMoviesList()

    private val _dataMoviesItemDetail = MutableLiveData<MovieSummary?>()
    val dataMoviesItemDetail: LiveData<MovieSummary?>
        get() = _dataMoviesItemDetail

    private val _showLoadingScreen = MutableLiveData(false)
    val showLoadingScreen: LiveData<Boolean>
        get() = _showLoadingScreen



    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        uiScope.launch {
            moviesUseCase.refreshSummaryList(1)
        }
    }

    fun onClickMoviesItem(movie: MovieSummary) {
        _dataMoviesItemDetail.postValue(movie)
    }

    fun onDataMoviesItemClicked(){
        _dataMoviesItemDetail.postValue(null)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}