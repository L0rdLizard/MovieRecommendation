package com.example.movierecommendation.data

import com.example.movierecommendation.R
import com.example.movierecommendation.module.MovieCard

class Datasource {
    fun loadMovieCards() :List<MovieCard>{
        return listOf<MovieCard>(
            MovieCard(R.string.movie_brat, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat2, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat3, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat4, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat5, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat6, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat7, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat8, R.drawable.movie_brat, R.string.movie_brat_description),
            MovieCard(R.string.movie_brat9, R.drawable.movie_brat, R.string.movie_brat_description),
        )
    }
}