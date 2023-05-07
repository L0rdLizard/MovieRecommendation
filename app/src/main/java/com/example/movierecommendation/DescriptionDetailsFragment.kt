package com.example.movierecommendation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.movierecommendation.databinding.FragmentMovieBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DescriptionDetailsFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMovieBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieBinding.bind(view)

        moviesViewModel.currentMovie.observe(this.viewLifecycleOwner) {
//            binding.titleDetail.text = getString(it.stringResourceId)
//            binding.moviesImageDetail.load(it.imageResourceId)
//            binding.description.text = getString(it.stringResourceId2)
            binding.titleDetail.text = getString(it.nameRu.toInt())
            binding.moviesImageDetail.load(R.drawable.movie_brat)
            binding.description.text = getString(it.shortDescription.toInt())
        }

    }
}
