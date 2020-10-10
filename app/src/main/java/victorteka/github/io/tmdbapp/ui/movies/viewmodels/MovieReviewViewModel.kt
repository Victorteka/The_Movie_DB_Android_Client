package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.data.models.reviews.Result
import victorteka.github.io.tmdbapp.data.repository.MovieReviewRepo
import victorteka.github.io.tmdbapp.utils.NetworkHelper
import victorteka.github.io.tmdbapp.utils.Resource

class MovieReviewViewModel @ViewModelInject constructor(
    private val movieReviewRepo: MovieReviewRepo,
    private val networkHelper: NetworkHelper
): ViewModel() {

    private val _reviews = MutableLiveData<Resource<List<Result>>>()
    val reviews: LiveData<Resource<List<Result>>>
        get() = _reviews

    fun fetchReviews(id: String){
        viewModelScope.launch {
            _reviews.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()){
                movieReviewRepo.getMovieReviews(id).let {
                    if (it.isSuccessful){
                        _reviews.postValue(Resource.success(it.body()?.results))
                    }else{
                        _reviews.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } else{
                _reviews.postValue(Resource.error("No internet connection", null))
            }
        }
    }
}