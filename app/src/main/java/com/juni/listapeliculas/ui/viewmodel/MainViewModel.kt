package com.juni.listapeliculas.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.juni.listapeliculas.data.local.getDataBase
import com.juni.listapeliculas.data.model.MovieModel
import com.juni.listapeliculas.domain.GetAllMovie
import com.juni.listapeliculas.domain.Movie
import kotlinx.coroutines.*
import java.net.UnknownHostException

class MainViewModel(application: Application) :AndroidViewModel(application) {

    private val _movieModelList=MutableLiveData<MutableList<Movie>>()
    private val movieDatabase= getDataBase(application)
    private val getPhotosDomain= GetAllMovie(movieDatabase)
    val movieModelList:LiveData<MutableList<Movie>>
    get()=_movieModelList

    init {
        viewModelScope.launch {
            _movieModelList.value=fetchMovies()
        }
    }

    private suspend fun fetchMovies(): MutableList<Movie> {
        val movieModelList= mutableListOf<Movie>()
        try {
            val getPhotosDomain= getPhotosDomain.getAllMovies()
            if (!getPhotosDomain.isNullOrEmpty()){
                for (movie in getPhotosDomain){
                    movieModelList.add(movie)
                }
            }
        }catch (e:UnknownHostException){

        }

        return movieModelList;
    }

}