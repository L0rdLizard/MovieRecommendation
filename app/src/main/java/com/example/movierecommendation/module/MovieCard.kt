package com.example.movierecommendation.module

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.squareup.moshi.Json

//data class MovieCard(
////    @StringRes val stringResourceId : Int,
////    @DrawableRes val imageResourceId : Int,
////    @StringRes val stringResourceId2 : Int)
//    val stringResourceId : Int,
//    val imageResourceId : Int,
//    val stringResourceId2 : Int)

data class MovieCard(val nameRu : String,
                      val kinopoiskId: Int,
                      @Json(name = "posterUrlPreview") val posterUrlPreview: String) {
}