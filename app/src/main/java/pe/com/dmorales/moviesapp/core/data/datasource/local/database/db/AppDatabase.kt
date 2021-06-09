package pe.com.dmorales.moviesapp.core.data.datasource.local.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.com.dmorales.moviesapp.core.data.datasource.local.database.dao.IMovieDao
import pe.com.dmorales.moviesapp.core.data.datasource.local.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): IMovieDao
}