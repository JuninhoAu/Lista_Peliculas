package com.juni.roverphotos.data.network

import com.juni.listapeliculas.api.RetrofitHelper
import com.juni.listapeliculas.data.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {

    suspend fun getMovies():List<MovieModel>{
        return withContext(Dispatchers.IO){
        var service: MovieApiClient = RetrofitHelper.getRetrofit().create(MovieApiClient::class.java)
        var ola=service.getMovies().body()!!.movieModels
          ola ?: emptyList<MovieModel>()
        }
    }

}