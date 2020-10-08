package victorteka.github.io.tmdbapp.ui.trendings.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.repository.TrendingRepo

class TrendingMovieViewModel @ViewModelInject constructor(private val apiHelper: ApiHelper): ViewModel() {

    val listResult = Pager(
        PagingConfig(pageSize = 10)
    ){
        TrendingRepo(apiHelper)
    }.liveData.cachedIn(viewModelScope)
}