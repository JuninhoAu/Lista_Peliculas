package com.juni.listapeliculas.domain
import com.juni.listapeliculas.data.local.MovieDatabase
import com.juni.listapeliculas.data.local.toDatabase
import com.juni.listapeliculas.data.model.MovieModel
import com.juni.listapeliculas.data.repositories.MovieRepository

class GetAllMovie(private val database: MovieDatabase) {
    private val repo= MovieRepository()

    suspend fun getAllMovies(): List<Movie>? {
        val moviesApi: List<Movie> = repo.getAllMoviesApi()
        database.movieDao.insertAllMovies(moviesApi.map { it.toDatabase() })
        return repo.getAllMoviesDatabase(database)
    }

}