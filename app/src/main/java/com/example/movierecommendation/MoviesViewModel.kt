
package com.example.movierecommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movierecommendation.data.Datasource
import com.example.movierecommendation.module.MovieCard
import com.example.movierecommendation.network.kinopoiskAPI
import com.example.movierecommendation.network.ParseMovie
import com.example.movierecommendation.network.objKinopoiskAPI
import kotlinx.coroutines.launch
import retrofit2.http.Path

class MoviesViewModel : ViewModel() {

    private var _currentMovie: MutableLiveData<MovieCard> = MutableLiveData<MovieCard>()
    val currentMovie: LiveData<MovieCard>
        get() = _currentMovie

    private var _moviesData: ArrayList<MovieCard> = ArrayList()
    val moviesData: ArrayList<MovieCard>
        get() = _moviesData

    init {
        getMovie("301")
        // Initialize the sports data.
        _moviesData = Datasource().loadMovieCards()
        _currentMovie.value = _moviesData[0]
    }

    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status
    private fun getMovie(id: String) {
        viewModelScope.launch {
            try {
                val listResult = objKinopoiskAPI.retrofitService.getMovie(id)
                _status.value = "Success: ${listResult.kinopoiskId} "
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
    fun updateCurrentSport(sport: MovieCard) {
        _currentMovie.value = sport
    }
}
