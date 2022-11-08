package com.juni.listapeliculas.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieEntity::class],version=1)
abstract class MovieDatabase :RoomDatabase(){
    abstract val movieDao:MovieDao
}

private lateinit var instance:MovieDatabase


fun getDataBase(context: Context):MovieDatabase{
    synchronized(MovieDatabase::class.java){
        if (!::instance.isInitialized){
            instance= Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java,
                "movie_db"
            ).fallbackToDestructiveMigration()
            .build()
        }
        return instance
    }
}