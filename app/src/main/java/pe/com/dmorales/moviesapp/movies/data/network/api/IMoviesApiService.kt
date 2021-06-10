package pe.com.dmorales.moviesapp.movies.data.network.api

import pe.com.dmorales.moviesapp.movies.data.network.response.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IMoviesApiService {
    @GET("3/movie/upcoming")
    suspend fun getMoviesSummaryList(@Query("page") page: Int): Response<MoviesResponse>
}