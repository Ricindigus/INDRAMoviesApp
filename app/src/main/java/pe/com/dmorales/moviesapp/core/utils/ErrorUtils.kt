package pe.com.dmorales.moviesapp.core.utils

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import pe.com.dmorales.moviesapp.core.data.datasource.remote.Result
import pe.com.dmorales.moviesapp.core.data.datasource.remote.StatusResponse
import pe.com.dmorales.moviesapp.core.domain.exceptions.NotFoundException
import pe.com.dmorales.moviesapp.core.domain.exceptions.RequestResouseForbiddenException
import pe.com.dmorales.moviesapp.core.domain.exceptions.UnExpectedException
import pe.com.dmorales.moviesapp.core.domain.exceptions.UnauthorizedException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException

object ErrorUtils {

    fun <T : Any> result(response: Response<*>): Result<T> {
        return Result.Error(handle(response.errorBody(), response.code()))
    }

    fun <T : Any> result(e: Throwable): Result<T> {
        return Result.Error(handle(e))
    }


    private fun handle(responseBody: ResponseBody?, statusCode: Int): Exception {
        val bodyJson = responseBody?.string()
        val errorResponse = Gson().fromJson(bodyJson, StatusResponse::class.java)

        return when (statusCode) {
            403 -> {
                RequestResouseForbiddenException(errorResponse.message)
            }
            401 -> {
                UnauthorizedException(errorResponse.message)
            }
            404 -> {
                NotFoundException(errorResponse.message)
            }
            0 -> {
                UnExpectedException("Response es diferente a la definida en la solicitud: $bodyJson")
            }
            else -> {
                UnExpectedException(errorResponse.message)
            }
        }
    }

    private fun handle(e: Throwable): Exception = when (e) {
        is SocketTimeoutException -> {
            pe.com.dmorales.moviesapp.core.domain.exceptions.SocketTimeoutException()
        }
        is ConnectException -> {
            pe.com.dmorales.moviesapp.core.domain.exceptions.ConnectException()
        }
        is HttpException -> {
            pe.com.dmorales.moviesapp.core.domain.exceptions.HttpException()
        }
        else -> {
            e as java.lang.Exception
        }
    }
}

suspend fun <T : Any> apiService(invoker: suspend Result<T>.() -> Result<T>): Result<T> {
    return try {
        withContext(Dispatchers.IO) {
            invoker(Result.Success(null))
        }
    } catch (e: Throwable) {
        ErrorUtils.result(e)
    }
}