package com.juni.listapeliculas.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.juni.listapeliculas.data.model.Movie
import com.juni.listapeliculas.databinding.FragmentMovieListBinding
import com.juni.listapeliculas.ui.viewmodel.MainViewModel
import java.lang.ClassCastException


class ListFragment : Fragment() {

    interface ItemSelectListener{
        fun onItemSelected(photos: Movie)
    }

    private lateinit var itemSelectListener: ItemSelectListener


    override fun onAttach(context: Context) {
        super.onAttach(context)
        itemSelectListener=try {
            context as ItemSelectListener
        }catch (e:ClassCastException){
            throw ClassCastException("$context debe implementar ItemSelectListerner")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view= FragmentMovieListBinding.inflate(inflater)

        val recycler=view.listareci

        recycler.layoutManager=LinearLayoutManager(requireActivity())

        val divider= DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)

        recycler.addItemDecoration(divider)

        val movieAdapter= MovieAdapter()

        recycler.adapter=movieAdapter

        val viewModel= ViewModelProvider(requireActivity())[MainViewModel::class.java]

        movieAdapter.onItemClickListener={

            itemSelectListener.onItemSelected(it)
        }


        viewModel.movieList.observe(viewLifecycleOwner) {
            movieAdapter.submitList(it)
        }

        return view.root

    }


}