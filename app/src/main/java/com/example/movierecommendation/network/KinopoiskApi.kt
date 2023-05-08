package com.example.movierecommendation.network

import com.example.movierecommendation.module.MovieCard
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.Call

//private const val BASE_URL =
//    "https://kinopoiskapiunofficial.tech/api/"
//
//private val client = OkHttpClient.Builder().build()
//
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .client(client)
//    .build()

//interface kinopoiskAPI {
//    @Headers("X-API-KEY: 74ba82e9-9bfc-42fe-90db-8c0981affdae")
////    @GET("v2.2/films/{id}")
//    @GET("https://kinopoiskapiunofficial.tech/api/v2.2/films/{movieId}")
////    suspend fun getMovie(): ParseMovie
//    suspend fun getMovie(@Path("movieId") kinoposikId: String) : MovieCard
//
//    @GET("v2.2/films/{id}/similars")
//    suspend fun getSimilars(@Path("id") kinoposikId: String) : List<MovieCard>
//}

//interface kinopoiskAPI {
//    @Headers("X-API-KEY: 74ba82e9-9bfc-42fe-90db-8c0981affdae")
//    @GET("https://kinopoiskapiunofficial.tech/api/v2.2/films/{movieId}")
//    fun getMovie(@Path("movieId") kinoposikId: String) : MovieCard
//}
//
//object objKinopoiskAPI {
//    val retrofitService: kinopoiskAPI by lazy { retrofit.create(kinopoiskAPI::class.java) }
//}

private const val BASE_URL =
    "https://kinopoiskapiunofficial.tech/api/"

interface kinopoiskAPI {
    @Headers("X-API-KEY: 74ba82e9-9bfc-42fe-90db-8c0981affdae")
    @GET("https://kinopoiskapiunofficial.tech/api/v2.2/films/{movieId}")
    fun getMovie(@Path("movieId") kinoposikId: Int): Call<MovieCard>
}

object objKinopoiskAPI {
    private val client = OkHttpClient.Builder().build()

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}