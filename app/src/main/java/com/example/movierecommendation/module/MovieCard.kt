package com.example.movierecommendation.module

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MovieCard(
    @StringRes val stringResourceId : Int,
    @DrawableRes val imageResourceId : Int) {
}