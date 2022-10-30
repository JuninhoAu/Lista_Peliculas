package com.juni.listapeliculas.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.juni.listapeliculas.R
import com.juni.listapeliculas.data.model.Movie

class MovieAdapter:ListAdapter<Movie, MovieAdapter.RoverViewHolder>(DiffCallback) {

    companion object DiffCallback:DiffUtil.ItemCallback<Movie>(){

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {

            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {

            return oldItem==newItem
        }

    }

    lateinit var onItemClickListener:(Movie)->Unit


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoverViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.movie_list_items,parent,false)
        return RoverViewHolder(view)

    }

    override fun onBindViewHolder(holder: RoverViewHolder, position: Int) {

        val movie=getItem(position)
        holder.bind(movie)

    }

    inner class RoverViewHolder( private val view:View):RecyclerView.ViewHolder(view){

        private val txtId =view.findViewById<TextView>(R.id.txtexto)
        private val txtName=view.findViewById<TextView>(R.id.txtexto)

        fun bind(movie: Movie){

           // txtId.text=String.format("%d", movie.id)
            txtName.text=movie.title

            view.setOnClickListener {
                if (::onItemClickListener.isInitialized){
                    onItemClickListener(movie)
                }
            }

        }

    }


}