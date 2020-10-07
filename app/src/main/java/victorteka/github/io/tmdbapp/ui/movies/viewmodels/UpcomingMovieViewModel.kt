package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.data.repository.UpcomingRepository
import victorteka.github.io.tmdbapp.utils.NetworkHelper
import victorteka.github.io.tmdbapp.utils.Resource

class UpcomingMovieViewModel @ViewModelInject constructor(
    private val upcomingRepository: UpcomingRepository,
    private val networkHelper: NetworkHelper): ViewModel() {

    private val _upcomingMovies = MutableLiveData<Resource<List<Result>>>()
    val upcomingMovies: LiveData<Resource<List<Result>>>
        get() = _upcomingMovies

    init {
        fetchUpcomingMovies()
    }

    private fun fetchUpcomingMovies() {
        viewModelScope.launch {
            _upcomingMovies.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                upcomingRepository.getUpcomingMovie().let {
                    if (it.isSuccessful){
                        _upcomingMovies.postValue(Resource.success(it.body()?.results))
                    } else _upcomingMovies.postValue(Resource.error(it.errorBody().toString(), null))
                }
            }else _upcomingMovies.postValue(Resource.error("No internet connection", null))
        }
    }

}