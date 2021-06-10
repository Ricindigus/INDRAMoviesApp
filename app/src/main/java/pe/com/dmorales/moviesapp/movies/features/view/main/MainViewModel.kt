package pe.com.dmorales.moviesapp.movies.features.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.com.dmorales.moviesapp.movies.domain.usecases.SessionUseCase

class MainViewModel(private val sessionUseCase: SessionUseCase): ViewModel() {
    private val _navigateToLogin = MutableLiveData<Boolean?>()
    val navigateToLogin: LiveData<Boolean?>
        get() = _navigateToLogin

    fun onClickItemLogout() {
        sessionUseCase.closeSession()
        _navigateToLogin.value = true
    }
}