package com.example.movierecommendation.data

import com.example.movierecommendation.module.MovieCard
//import com.example.movierecommendation.network.RestApiService
import com.example.movierecommendation.network.objKinopoiskAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Datasource {

    private var movies = ArrayList<MovieCard>()

//    private var movies :MutableLiveData<ArrayList<MovieCard>> = MutableLiveData()
//    public fun addNewMovie(id: String) = liveData<MovieCard> {
//    println("ппппппппппппппппппппппппппппппппппппппппппппппппппппппппппппппппппппппппп")
//        try {
//            val result = objKinopoiskAPI.retrofitService.getMovie(id)
//            println("addNewMovie result: ")
//            println(result.toString())
//            movies.add(result)
//        } catch (e: Exception) {
//            println("444444444444444444444${e.message}")
//        }
//    }

    suspend fun addNewMovie(id: Int) {
//        CoroutineScope(Dispatchers.Main).launch {
            try {
//                val apiService = RestApiService()
//                apiService.getMovie(id){
//                    if (it?.kinopoiskId != null) {
//                        println("ura pobeda")
//                        println(it.toString())
//                        movies.add(it)
//                    }
//                }
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