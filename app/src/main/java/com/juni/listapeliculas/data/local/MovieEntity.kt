package com.juni.listapeliculas.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juni.listapeliculas.domain.Movie


@Entity(tableName = "Movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,

)

fun Movie.toDatabase()= MovieEntity(id,overview,posterPath,releaseDate,title, voteAverage)