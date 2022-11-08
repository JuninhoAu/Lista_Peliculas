package com.juni.listapeliculas.data.repositories

import com.juni.listapeliculas.data.local.MovieDatabase
import com.juni.listapeliculas.data.local.MovieEntity
import com.juni.listapeliculas.data.model.MovieModel
import com.juni.listapeliculas.domain.Movie
import com.juni.listapeliculas.domain.toDomain
import com.juni.roverphotos.data.network.MovieService

class MovieRepository {
    private val api=MovieService();

    suspend  fun getAllMoviesApi():List<Movie>{
        val response=api.getMovies()
        return response.map { it.toDomain() }

    }

    suspend fun getAllMoviesDatabase(database: MovieDatabase):List<Movie>{
       val response= database.movieDao.getAllMovies()
        return response.map { it.toDomain() }

    }

    suspend fun insertMoviesDatabase(database: MovieDatabase,movies: List<MovieEntity>){
       database.movieDao.insertAllMovies(movies)

    }
}