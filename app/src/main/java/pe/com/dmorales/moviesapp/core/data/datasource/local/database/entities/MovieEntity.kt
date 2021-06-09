package pe.com.dmorales.moviesapp.core.data.datasource.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    val backdropImage: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: String,
    val posterImage: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: String,
    val voteCount: String
)
