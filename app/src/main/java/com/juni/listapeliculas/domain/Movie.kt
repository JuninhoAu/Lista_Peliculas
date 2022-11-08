package com.juni.listapeliculas.domain

import android.os.Parcelable
import com.juni.listapeliculas.data.local.MovieEntity
import com.juni.listapeliculas.data.model.MovieModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val id: Int,
                  val overview: String,
                  val posterPath: String,
                  val releaseDate: String,
                  val title: String,
                  val voteAverage: Double): Parcelable


fun MovieModel.toDomain()=Movie(id,overview,posterPath,releaseDate,title, voteAverage)
fun MovieEntity.toDomain()=Movie(id,overview,posterPath,releaseDate,title, voteAverage)