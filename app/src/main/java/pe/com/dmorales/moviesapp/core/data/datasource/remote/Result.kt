package pe.com.dmorales.moviesapp.core.data.datasource.remote

import pe.com.dmorales.moviesapp.core.utils.ErrorUtils
import retrofit2.Response

sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T?) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    data class Errors(val exceptions: List<Exception>) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Errors -> "Errors[exception=$exceptions]"
        }
    }

    inline fun <reified T : Any> success(invoker: () -> T?): Result<T> {
        return Success(invoker())
    }

    fun error(invoker: () -> Response<*>): Result<T> {
        return ErrorUtils.result(invoker())
    }
}