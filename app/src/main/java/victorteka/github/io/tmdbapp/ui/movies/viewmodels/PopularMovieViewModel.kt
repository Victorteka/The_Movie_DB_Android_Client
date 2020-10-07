package victorteka.github.io.tmdbapp.ui.movies.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.repository.PopularMovieRepo

class PopularMovieViewModel @ViewModelInject constructor(private val apiHelper: ApiHelper)
    : ViewModel() {
    val listResults = Pager(
        PagingConfig(pageSize = 10, enablePlaceholders = false)
    ){
        PopularMovieRepo(apiHelper)
    }.liveData.cachedIn(viewModelScope)
}