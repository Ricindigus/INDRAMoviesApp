package pe.com.dmorales.moviesapp.login.data.repository

import pe.com.dmorales.moviesapp.core.data.datasource.remote.Result
import pe.com.dmorales.moviesapp.login.data.datastore.FakeLoginCloudStore
import pe.com.dmorales.moviesapp.login.data.network.request.AuthRequest
import pe.com.dmorales.moviesapp.login.domain.entities.UserData

class LoginRepository(private val fakeLoginCloudStore: FakeLoginCloudStore) {
    suspend fun loginUser(user: String, password:String): Result<UserData>{
        val authRequest = AuthRequest(user,password)
        return fakeLoginCloudStore.authenticateUser(authRequest)
    }
}