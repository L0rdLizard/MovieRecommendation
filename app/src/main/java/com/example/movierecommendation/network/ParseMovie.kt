package com.example.movierecommendation.network

import com.squareup.moshi.Json

data class ParseMovie(val kinopoiskId: Int, @Json(name = "posterUrlPreview") val posterUrlPreview: String) {
}