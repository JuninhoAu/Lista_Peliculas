package com.juni.listapeliculas.domain
import com.juni.listapeliculas.data.model.Movie
import com.juni.listapeliculas.data.repositories.MovieRepository

class GetAllMovie {
    private val repo= MovieRepository()


    suspend  fun getAllMovies(): List<Movie>? {
         return repo.getAllMovies()
    }


}