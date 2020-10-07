package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.data.repository.UpcomingRepository
import victorteka.github.io.tmdbapp.utils.NetworkHelper
import victorteka.github.io.tmdbapp.utils.Resource

class UpcomingMovieViewModel @ViewModelInject constructor(
    private val apiHelper: ApiHelper,
    private val networkHelper: NetworkHelper): ViewModel() {

    val listResult = Pager(
        PagingConfig(pageSize = 10, enablePlaceholders = false)
    ){
        UpcomingRepository(apiHelper)
    }.liveData.cachedIn(viewModelScope)

}