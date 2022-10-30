package com.juni.listapeliculas.data.repositories

import com.juni.listapeliculas.data.model.Movie
import com.juni.roverphotos.data.network.MovieService

class MovieRepository {
    private val api=MovieService();

    suspend  fun getAllMovies():List<Movie>{
        val response=api.getMovies();
        return response

    }
}