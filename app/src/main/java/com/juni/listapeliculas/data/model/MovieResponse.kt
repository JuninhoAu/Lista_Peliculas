package com.juni.listapeliculas.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movieModels:List<MovieModel>

        ):Parcelable{
            constructor(): this(mutableListOf())
        }