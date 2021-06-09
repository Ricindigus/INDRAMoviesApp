package pe.com.dmorales.moviesapp.core.data.datasource.remote

import com.google.gson.annotations.SerializedName

data class StatusResponse(
        @SerializedName("code")
        val code: Int,
        @SerializedName("message")
        val message: String
)