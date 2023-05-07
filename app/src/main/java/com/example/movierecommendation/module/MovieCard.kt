package com.example.movierecommendation.module

import com.squareup.moshi.Json

data class MovieCard(val nameRu : String,
                      val kinopoiskId: Int,
                     val shortDescription : String,
                      @Json(name = "posterUrlPreview") val posterUrlPreview: String) {
}
