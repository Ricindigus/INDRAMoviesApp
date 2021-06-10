package pe.com.dmorales.moviesapp.movies.data.mappers

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import pe.com.dmorales.moviesapp.core.data.datasource.local.database.entities.MovieEntity
import pe.com.dmorales.moviesapp.movies.domain.entities.MovieSummary

fun MovieEntity.asDomainModel() =
    MovieSummary(
        adult = adult,
        backdropImage = backdropImage,
        id = id,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        popularity = popularity,
        posterImage = posterImage,
        releaseDate = releaseDate,
        title = title,
        voteAverage = voteAverage,
        voteCount = voteCount
    )

fun List<MovieEntity>.asDomainModel(): List<MovieSummary> {
    return map {
        it.asDomainModel()
    }
}

fun LiveData<List<MovieEntity>>.asDomainModel(): LiveData<List<MovieSummary>> {
    return map { it.asDomainModel() }
}
