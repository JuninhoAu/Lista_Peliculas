package com.juni.listapeliculas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.juni.listapeliculas.R
import com.juni.listapeliculas.data.model.Movie
import com.juni.listapeliculas.databinding.ActivityMainBinding
import com.juni.listapeliculas.ui.viewmodel.MainViewModel
import com.juni.listapeliculas.ui.fragments.ListFragment
import com.juni.listapeliculas.ui.fragments.MovieFragment

class MainActivity : AppCompatActivity(), ListFragment.ItemSelectListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var movieFragment: MovieFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        movieFragment=supportFragmentManager.findFragmentById(R.id.rover_photos) as MovieFragment
        // binding.roverRecycle.layoutManager=LinearLayoutManager(this)
        val viewModel= ViewModelProvider(this)[MainViewModel::class.java]



    }

    override fun onItemSelected(movie: Movie) {
        movieFragment.setPhotos(movie)
    }


}