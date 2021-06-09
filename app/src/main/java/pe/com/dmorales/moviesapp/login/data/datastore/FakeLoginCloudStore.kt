package pe.com.dmorales.moviesapp.login.data.datastore

import pe.com.dmorales.moviesapp.core.data.datasource.remote.Result
import pe.com.dmorales.moviesapp.core.utils.apiService
import pe.com.dmorales.moviesapp.login.data.mappers.asDomainModel
import pe.com.dmorales.moviesapp.login.data.network.api.IAuthenticationService
import pe.com.dmorales.moviesapp.login.data.network.request.AuthRequest
import pe.com.dmorales.moviesapp.login.domain.entities.UserData

class FakeLoginCloudStore(private val authenticationService: IAuthenticationService) {
    suspend fun authenticateUser(authRequest: AuthRequest): Result<UserData> {
        return apiService {
            val response = authenticationService.authenticateUser(authRequest)
            if (response.isSuccessful) {
                val body = response.body()
                val userData = body?.asDomainModel()
                success { userData }
            } else
                error { response }
        }
    }
}