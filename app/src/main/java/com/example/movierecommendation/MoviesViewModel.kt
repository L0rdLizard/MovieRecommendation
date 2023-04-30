
package com.example.movierecommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movierecommendation.data.Datasource
import com.example.movierecommendation.module.MovieCard

class MoviesViewModel : ViewModel() {

    private var _currentMovie: MutableLiveData<MovieCard> = MutableLiveData<MovieCard>()
    val currentMovie: LiveData<MovieCard>
        get() = _currentMovie

    private var _moviesData: ArrayList<MovieCard> = ArrayList()
    val sportsData: ArrayList<MovieCard>
        get() = _moviesData

    init {
        // Initialize the sports data.
        _moviesData = Datasource().loadMovieCards()
        _currentMovie.value = _moviesData[0]
    }

    fun updateCurrentSport(sport: MovieCard) {
        _currentMovie.value = sport
    }
}
