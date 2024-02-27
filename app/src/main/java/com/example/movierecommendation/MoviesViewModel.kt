
package com.example.movierecommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movierecommendation.data.Datasource
import com.example.movierecommendation.module.MovieCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    private var _currentMovie: MutableLiveData<MovieCard> = MutableLiveData<MovieCard>()
//    private val movieList = Datasource()
    val currentMovie: LiveData<MovieCard>
        get() = _currentMovie

    private var _moviesData: ArrayList<MovieCard> = ArrayList()
    val moviesData: ArrayList<MovieCard>
        get() = _moviesData

    init {
        val movieList = Datasource()
        // Initialize the movie data.
        CoroutineScope(Dispatchers.Main).launch {
            movieList.addNewMovie(301)
            movieList.addNewMovie(302)
            movieList.addNewMovie(303)
            movieList.addNewMovie(304)
            movieList.addNewMovie(305)
            movieList.addNewMovie(306)

            _moviesData = movieList.loadMovieCards()
            println("Test 1111111111111111111111111111111111111111111")
            println(movieList.loadMovieCards())
            println(_moviesData)

            if (_moviesData.size != 0) {
                println("all is ok1111111111111111111111111111111111111111111")
//                _currentMovie.value = _moviesData[0]
//                _currentMovie.postValue(_moviesData[0])
                println(_moviesData[0])
                _currentMovie.value = _moviesData[0]
            }
        }

    }

    fun updateCurrentMovie(movie: MovieCard) {
        _currentMovie.value = movie
    }
}
