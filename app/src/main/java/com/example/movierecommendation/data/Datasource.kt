package com.example.movierecommendation.data

import androidx.lifecycle.viewModelScope
import com.example.movierecommendation.R
import com.example.movierecommendation.module.MovieCard
import com.example.movierecommendation.network.objKinopoiskAPI
import kotlinx.coroutines.launch

class Datasource {

    private var movies = ArrayList<MovieCard>()
    suspend fun addNewMovie(id: String) {
            try {
                val result = objKinopoiskAPI.retrofitService.getMovie(id)
                movies.add(result)
            } catch (e: Exception) {

            }
    }
//    fun loadMovieCards() :ArrayList<MovieCard>{
//        return arrayListOf<MovieCard>(
//            MovieCard(R.string.movie_brat, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat2, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat3, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat4, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat5, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat6, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat7, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat8, R.drawable.movie_brat, R.string.movie_brat_description),
//            MovieCard(R.string.movie_brat9, R.drawable.movie_brat, R.string.movie_brat_description),
//        )
//    }
}