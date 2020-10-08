package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.repository.UpcomingRepository
import victorteka.github.io.tmdbapp.utils.NetworkHelper

class UpcomingMovieViewModel @ViewModelInject constructor(
    private val apiHelper: ApiHelper,
    private val networkHelper: NetworkHelper): ViewModel() {

    val listResult = Pager(
        PagingConfig(pageSize = 10, enablePlaceholders = false)
    ){
        UpcomingRepository(apiHelper)
    }.liveData.cachedIn(viewModelScope)

}