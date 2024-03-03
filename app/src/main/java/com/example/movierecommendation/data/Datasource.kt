package com.example.movierecommendation.data

import com.example.movierecommendation.module.MovieCard
//import com.example.movierecommendation.network.RestApiService
import com.example.movierecommendation.network.objKinopoiskAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Datasource {

    private var movies = ArrayList<MovieCard>()

    suspend fun addNewMovie(id: Int) {

            try {
                val result = objKinopoiskAPI.retrofitService.getMovie(id)
                println("addNewMovie number $id result: ")
                println(result.toString())
                movies.add(result)
                println(movies)
            } catch (e: Exception) {
                println("444444444444444444444${e.message}")
            }
//        }
    }

    fun loadMovieCards(): ArrayList<MovieCard> {
        return movies
    }
}