package com.juni.roverphotos.data.network

import com.juni.listapeliculas.data.model.MovieResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiClient {

    @GET("upcoming?page=1&api_key=f46b58478f489737ad5a4651a4b25079")
    suspend fun getMovies(): Response<MovieResponse>


}