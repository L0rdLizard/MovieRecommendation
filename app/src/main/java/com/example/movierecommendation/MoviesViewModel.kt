
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
    val currentMovie: LiveData<MovieCard>
        get() = _currentMovie


    private var _moviesData: MutableLiveData<ArrayList<MovieCard>> = MutableLiveData()
    val moviesData: LiveData<ArrayList<MovieCard>>
        get() = _moviesData

    init {
        val movieList = Datasource()

        CoroutineScope(Dispatchers.Main).launch {
            movieList.addNewMovie(301)
            movieList.addNewMovie(302)
            movieList.addNewMovie(303)
            movieList.addNewMovie(304)
            movieList.addNewMovie(305)
            movieList.addNewMovie(306)

            _moviesData.value = movieList.loadMovieCards()
            println("Test 1111111111111111111111111111111111111111111")
            println(movieList.loadMovieCards())
            println(_moviesData)

            if (_moviesData.value?.isNotEmpty() == true) {
                println("all is ok1111111111111111111111111111111111111111111")

                println(_moviesData.value!![0])

                _currentMovie.value = _moviesData.value!![0]
            }
        }

    }

    fun updateCurrentMovie(movie: MovieCard) {
        _currentMovie.value = movie
    }
}
