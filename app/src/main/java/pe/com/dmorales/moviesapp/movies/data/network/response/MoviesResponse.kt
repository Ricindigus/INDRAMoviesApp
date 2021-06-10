package pe.com.dmorales.moviesapp.movies.data.network.response

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("dates")
    val dates: DatesResponse,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val moviesData: List<MovieSummaryResponse>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
){
    data class DatesResponse(
        @SerializedName("maximum")
        val maximum: String,
        @SerializedName("minimum")
        val minimum: String
    )

    data class MovieSummaryResponse(
        @SerializedName("adult")
        val adult: Boolean,
        @SerializedName("backdrop_path")
        val backdropPath: String,
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        @SerializedName("id")
        val id: Int,
        @SerializedName("original_language")
        val originalLanguage: String,
        @SerializedName("original_title")
        val originalTitle: String,
        @SerializedName("overview")
        val overview: String,
        @SerializedName("popularity")
        val popularity: Double,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("release_date")
        val releaseDate: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("video")
        val video: Boolean,
        @SerializedName("vote_average")
        val voteAverage: Double,
        @SerializedName("vote_count")
        val voteCount: Int
    )
}