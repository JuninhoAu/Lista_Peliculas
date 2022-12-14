package com.juni.listapeliculas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.juni.listapeliculas.R
import com.juni.listapeliculas.data.model.MovieModel
import com.juni.listapeliculas.databinding.ActivityMainBinding
import com.juni.listapeliculas.domain.Movie
import com.juni.listapeliculas.ui.fragments.ListFragment
import com.juni.listapeliculas.ui.fragments.ListFragmentDirections
import com.juni.listapeliculas.ui.fragments.LoginFragment
import com.juni.listapeliculas.ui.fragments.LoginFragmentDirections

class MainActivity : AppCompatActivity(), ListFragment.ItemSelectListener, LoginFragment.ListSelectListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun showMovieList() {
        findNavController(R.id.main_navigation_container).navigate(LoginFragmentDirections.actionLoginFragmentToListFragment())
    }

    override fun onItemSelected(movie: Movie) {
        findNavController(R.id.main_navigation_container).navigate(ListFragmentDirections.actionListFragmentToMovieFragment2(movie))
    }


}