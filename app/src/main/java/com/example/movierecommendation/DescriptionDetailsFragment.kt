package com.example.movierecommendation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.movierecommendation.databinding.FragmentMovieBinding

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
//            binding.moviesImageDetail.load(R.drawable.movie_brat)
            binding.titleDetail.text = it.nameRu
            binding.moviesImageDetail.load(it.posterUrlPreview) {
                crossfade(true)
                placeholder(R.drawable.placeholder)
                error(R.drawable.error)
            }
            binding.description.text = it.shortDescription
        }

    }
}
