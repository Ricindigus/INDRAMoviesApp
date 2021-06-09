package pe.com.dmorales.moviesapp.login.features.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import pe.com.dmorales.moviesapp.login.domain.usecases.LoginUseCase
import java.util.concurrent.TimeUnit
import pe.com.dmorales.moviesapp.core.data.datasource.remote.Result

class LoginViewModel(private val loginUseCase: LoginUseCase): ViewModel() {
    val usernameValue = MutableLiveData<String>()
    val passwordValue = MutableLiveData<String>()

    private val _initSessionUser = MutableLiveData<Boolean>(false)
    val initSessionUser: LiveData<Boolean>
        get() = _initSessionUser

    private val _enableContinueButton = MutableLiveData<Boolean>(false)
    val enableContinueButton: LiveData<Boolean>
        get() = _enableContinueButton

    private val _showLoadingScreen = MutableLiveData(false)
    val showLoadingScreen: LiveData<Boolean>
        get() = _showLoadingScreen

    private val _showErrorCredentials = MutableLiveData<Boolean>(false)
    val showErrorCredentials: LiveData<Boolean>
        get() = _showErrorCredentials

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun validateFields() {
        _enableContinueButton.value = usernameValue.value != null && passwordValue.value != null
    }

    fun attemptLogin(){
        showLoading()
        uiScope.launch {
            delay(TimeUnit.SECONDS.toMillis(2))
            when (val result = loginUseCase.loginUser(usernameValue.value!!, passwordValue.value!!)) {
                is Result.Success -> {
                    _initSessionUser.postValue(true)
                }
                is Result.Error -> {
                    _showErrorCredentials.postValue(true)
                }
            }
            hideLoading()
        }
    }

    private fun showLoading(): Unit = _showLoadingScreen.postValue(true)
    private fun hideLoading(): Unit = _showLoadingScreen.postValue(false)

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}