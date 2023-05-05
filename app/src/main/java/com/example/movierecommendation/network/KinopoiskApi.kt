package com.example.movierecommendation.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


private const val BASE_URL =
    "https://kinopoiskapiunofficial.tech/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

interface kinopoiskAPI {
    @Headers("X-API-KEY: 74ba82e9-9bfc-42fe-90db-8c0981affdae")
    @GET("https://kinopoiskapiunofficial.tech/api/v2.2/films/301")
    suspend fun getMovie(): ParseMovie
}

object objKinopoiskAPI {
    val retrofitService: kinopoiskAPI by lazy { retrofit.create(kinopoiskAPI::class.java) }
}