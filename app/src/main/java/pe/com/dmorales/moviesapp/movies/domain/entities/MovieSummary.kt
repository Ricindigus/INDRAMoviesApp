package pe.com.dmorales.moviesapp.movies.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieSummary(
    val adult: Boolean,
    val backdropImage: String,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: String,
    val posterImage: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: String,
    val voteCount: String
):Parcelable