package pe.com.dmorales.moviesapp.movies.data.mappers

import pe.com.dmorales.moviesapp.core.data.datasource.local.database.entities.MovieEntity
import pe.com.dmorales.moviesapp.movies.data.network.response.MoviesResponse


fun MoviesResponse.asDatabaseModel(): Array<MovieEntity> {
    return moviesData.map {
        MovieEntity(
            id = it.id,
            adult = it.adult,
            backdropImage = "$BASE_URL_IMAGE${it.backdropPath}",
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            overview = it.overview,
            popularity = it.popularity.toString(),
            posterImage = "$BASE_URL_IMAGE${it.posterPath}",
            releaseDate = it.releaseDate,
            title = it.title,
            voteAverage = it.voteAverage.toString(),
            voteCount = it.voteCount.toString()
        )
    }.toTypedArray()
}

const val BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500"