package com.juni.listapeliculas.ui.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.juni.listapeliculas.R


class MovieFragment : Fragment() {

    private val args:MovieFragmentArgs by navArgs()

    private lateinit var imageView: ImageView
    private lateinit var name: TextView
    private lateinit var fecha: TextView
    private lateinit var voto: TextView
    private lateinit var des: TextView






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  viewRoot= inflater.inflate(R.layout.fragment_movie_details, container, false)

        imageView=viewRoot.findViewById(R.id.imgv_rover)
        name=viewRoot.findViewById(R.id.txtMovieName)
        fecha=viewRoot.findViewById(R.id.txtMovieFecha)
        voto=viewRoot.findViewById(R.id.txtMovieNota)
        des=viewRoot.findViewById(R.id.txtMovieDe)


        val movie=args.movie

        val movieTitle =movie.title
        val releaseDate=movie.releaseDate
        val voteAverage=movie.voteAverage
        val posterPath=movie.posterPath

       // name.setText(movieTitle)
      //  fecha.setText(releaseDate)
        voto.setText(voteAverage.toString())
        des.setText(movie.overview)

        setPhotos(posterPath)

        return viewRoot
    }

    fun setPhotos(posterPath: String){

        Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+posterPath).listener(object : RequestListener<Drawable> {

            override fun onLoadFailed(e: GlideException?,
                                      model: Any?,
                                      target: Target<Drawable>?,
                                      isFirstResource: Boolean): Boolean {

                showMsg("carga fallida"+e)

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