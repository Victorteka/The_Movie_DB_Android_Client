package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.data.repository.RecommendationRepo
import victorteka.github.io.tmdbapp.utils.NetworkHelper
import victorteka.github.io.tmdbapp.utils.Resource

class RecommendationViewModel @ViewModelInject constructor(
    private val recommendationRepo: RecommendationRepo,
    private val networkHelper: NetworkHelper
) :
    ViewModel() {

    private val _recommendations = MutableLiveData<Resource<List<Result>>>()

    val recommendations: LiveData<Resource<List<Result>>>
        get() = _recommendations


    fun fetchRecommendations(id: String) {
        viewModelScope.launch {
            _recommendations.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                recommendationRepo.getMovieRecommendations(id).let {
                    if (it.isSuccessful){
                        _recommendations.postValue(Resource.success(it.body()?.results))
                    }else{
                        _recommendations.postValue(Resource.error(it.errorBody().toString(),null))
                    }
                }
            }else _recommendations.postValue(Resource.error("No Internet connection", null))
        }
    }

}