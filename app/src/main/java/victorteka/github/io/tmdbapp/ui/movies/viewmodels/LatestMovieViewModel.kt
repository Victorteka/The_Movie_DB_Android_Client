package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.models.latest.Latest
import victorteka.github.io.tmdbapp.data.repository.LatestRepo
import victorteka.github.io.tmdbapp.utils.NetworkHelper
import victorteka.github.io.tmdbapp.utils.Resource

class LatestMovieViewModel @ViewModelInject constructor(
    private val latestRepo: LatestRepo,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _latestMovie = MutableLiveData<Resource<Latest>>()
    val latestMovie: LiveData<Resource<Latest>>
        get() = _latestMovie

    init {
        fetchLatestMovie()
    }

    private fun fetchLatestMovie() {
        viewModelScope.launch {
            _latestMovie.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                latestRepo.getLatestMovie().let {
                    if (it.isSuccessful){
                        _latestMovie.postValue(Resource.success(it.body()))
                    }else _latestMovie.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _latestMovie.postValue(Resource.error("No internet connection", null))
        }
    }
}