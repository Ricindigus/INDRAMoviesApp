package pe.com.dmorales.moviesapp.splash.features.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pe.com.dmorales.moviesapp.splash.domain.usecases.SplashUseCase
import java.util.concurrent.TimeUnit

class SplashViewModel(private val splashUseCase: SplashUseCase): ViewModel() {


    private val _navigateToMain = MutableLiveData<Boolean?>()
    val navigateToMain: LiveData<Boolean?>
        get() = _navigateToMain

    private val _navigateToLogin = MutableLiveData<Boolean?>()
    val navigateToLogin: LiveData<Boolean?>
        get() = _navigateToLogin

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun checkSessionUser() {
        uiScope.launch {
            delay(TimeUnit.SECONDS.toMillis(3))
            if(splashUseCase.isLogged()){
                _navigateToMain.value = true
            }else{
                _navigateToLogin.value = true
            }
        }
    }

    fun doneNavigateToLogin() {
        _navigateToLogin.value = null
    }

    fun doneNavigateToMain() {
        _navigateToMain.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}