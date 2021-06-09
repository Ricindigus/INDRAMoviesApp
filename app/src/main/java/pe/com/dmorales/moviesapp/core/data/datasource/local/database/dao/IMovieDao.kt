package pe.com.dmorales.moviesapp.core.data.datasource.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import pe.com.dmorales.moviesapp.core.data.datasource.local.database.entities.MovieEntity

@Dao
interface IMovieDao {
    @Query("select * from movies_table")
    fun getMoviesList(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg movies: MovieEntity)
}