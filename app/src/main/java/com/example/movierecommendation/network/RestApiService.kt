package com.example.movierecommendation.network

import com.example.movierecommendation.module.MovieCard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun getMovie(id : Int, onResult: (MovieCard?) -> Unit){
        val retrofit = objKinopoiskAPI.buildService(kinopoiskAPI::class.java)
        retrofit.getMovie(id).enqueue(
            object : Callback<MovieCard> {
                override fun onFailure(call: Call<MovieCard>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<MovieCard>, response: Response<MovieCard>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}