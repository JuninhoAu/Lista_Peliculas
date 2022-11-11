package com.juni.listapeliculas.ui.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.juni.listapeliculas.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment() {

    private val args:MovieDetailsFragmentArgs by navArgs()
    private lateinit var binding:FragmentMovieDetailsBinding
    private lateinit var imageView: ImageView
    private lateinit var name: TextView
    private lateinit var fecha: TextView
    private lateinit var voto: TextView
    private lateinit var des: TextView
    private lateinit var pdMovieImage: ProgressBar


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentMovieDetailsBinding.inflate(inflater)
        imageView=binding.imgvRover
        name=binding.txtMovieName
        fecha=binding.txtMovieFecha
        voto=binding.txtMovieNota
        des=binding.txtMovieDe
        pdMovieImage=binding.pbMovie
        val movie=args.movie
        val movieTitle =movie.title
        val releaseDate=movie.releaseDate
        val voteAverage=movie.voteAverage
        val posterPath=movie.posterPath

        name.text=movieTitle
        fecha.text=releaseDate
        voto.text = voteAverage.toString()
        des.text = movie.overview

        setPhotos(posterPath)

        return binding.root
    }

    private fun setPhotos(posterPath: String){

        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+posterPath).listener(object : RequestListener<Drawable> {

            override fun onLoadFailed(e: GlideException?,
                                      model: Any?,
                                      target: Target<Drawable>?,
                                      isFirstResource: Boolean): Boolean {

                showMsg("carga fallida: "+e)

                return false
            }

            override fun onResourceReady(resource: Drawable?,
                                         model: Any?,
                                         target: Target<Drawable>?,
                                         dataSource: DataSource?,
                                         isFirstResource: Boolean): Boolean {
                return false
            }


        })
        //.error(R.drawable.ic_launcher_background)
        .into(imageView)

    }

    private fun showMsg(message:String){
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()

    }


}