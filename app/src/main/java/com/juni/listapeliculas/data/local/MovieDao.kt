package com.juni.listapeliculas.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juni.listapeliculas.data.model.MovieModel

@Dao
interface MovieDao {

     @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertAllMovies(movieList:List<MovieEntity>)


    @Query("Select * from Movie_table")
    suspend fun getAllMovies():List<MovieEntity>

}