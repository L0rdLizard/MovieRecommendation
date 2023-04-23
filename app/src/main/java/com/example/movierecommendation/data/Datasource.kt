package com.example.movierecommendation.data

import com.example.movierecommendation.R
import com.example.movierecommendation.module.MovieCard

class Datasource {
    fun loadMovieCards() :List<MovieCard>{
        return listOf<MovieCard>(
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat),
            MovieCard(R.string.movie_brat, R.drawable.movie_brat)
        )
    }
}