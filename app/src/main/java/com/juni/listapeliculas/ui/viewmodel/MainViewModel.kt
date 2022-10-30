package com.juni.listapeliculas.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juni.listapeliculas.data.model.Movie
import com.juni.listapeliculas.domain.GetAllMovie
import kotlinx.coroutines.*

class MainViewModel:ViewModel() {

    private val getPhotosDomain= GetAllMovie()
    private val _movieList=MutableLiveData<MutableList<Movie>>()
    val movieList:LiveData<MutableList<Movie>>
    get()=_movieList


    init {
        viewModelScope.launch {
            _movieList.value=fetchMovies()
        }
    }

    private suspend fun fetchMovies(): MutableList<Movie> {
        val movieList= mutableListOf<Movie>()
        val getPhotosDomain= getPhotosDomain.getAllMovies()
        if (!getPhotosDomain.isNullOrEmpty()){
            for (movie in getPhotosDomain){
                movieList.add(movie)
            }
        }
        return movieList;
    }

}