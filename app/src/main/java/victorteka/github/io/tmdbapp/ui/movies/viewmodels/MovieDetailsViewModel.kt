package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.data.models.moviedetails.MovieDetail
import victorteka.github.io.tmdbapp.data.repository.MovieDetailsRepo

class MovieDetailsViewModel @ViewModelInject constructor(private val movieDetailsRepo: MovieDetailsRepo): ViewModel() {

    val movieId = MutableLiveData<Int>()


    private val _movieDetails = MutableLiveData<MovieDetail>()
    val movieDetails: LiveData<MovieDetail>
        get() = _movieDetails

    fun fetchMovieDetails(id: String) {
        viewModelScope.launch {
           val results = movieDetailsRepo.getMovieDetail(id)
            _movieDetails.postValue(results.body())
        }
    }

}