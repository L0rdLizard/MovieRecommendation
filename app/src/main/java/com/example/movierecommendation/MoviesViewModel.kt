
package com.example.movierecommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movierecommendation.data.Datasource
import com.example.movierecommendation.module.MovieCard
import com.example.movierecommendation.MainActivity
import com.example.movierecommendation.network.kinopoiskAPI
import com.example.movierecommendation.network.ParseMovie
import com.example.movierecommendation.network.objKinopoiskAPI
import kotlinx.coroutines.launch
import retrofit2.http.Path

class MoviesViewModel : ViewModel() {

    private var _currentMovie: MutableLiveData<MovieCard> = MutableLiveData<MovieCard>()
    private val movieList :Datasource = Datasource()
    val currentMovie: LiveData<MovieCard>
        get() = _currentMovie

    private var _moviesData: ArrayList<MovieCard> = ArrayList()
    val moviesData: ArrayList<MovieCard>
        get() = _moviesData

    init {
        // Initialize the movie data.
        movieList.addNewMovie("301")
//        _moviesData = Datasource().loadMovieCards()
        _moviesData = movieList.loadMovieCards()
        println("Test 1111111111111111111111111111111111111111111")
        println(movieList.loadMovieCards())
        println(_moviesData)
        if (_moviesData.size != 0) {
            println("all is ok1111111111111111111111111111111111111111111")
            _currentMovie.value = _moviesData[0]
        }
    }

//    private val _status = MutableLiveData<String>()
//
//    val status: LiveData<String> = _status
//    fun getMovie(id: String) {
//        viewModelScope.launch {
//            try {
//                val listResult = objKinopoiskAPI.retrofitService.getMovie(id)
//                _status.value = "Success: ${listResult.kinopoiskId} "
//            } catch (e: Exception) {
//                _status.value = "Failure: ${e.message}"
//            }
//        }
//    }
    fun updateCurrentMovie(movie: MovieCard) {
        _currentMovie.value = movie
    }
}
