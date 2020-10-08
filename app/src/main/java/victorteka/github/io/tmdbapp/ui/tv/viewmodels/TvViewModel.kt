package victorteka.github.io.tmdbapp.ui.tv.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.repository.TvLiveRepo

class TvViewModel @ViewModelInject constructor(private val apiHelper: ApiHelper): ViewModel() {
    val tvResult = Pager(
        PagingConfig(pageSize = 10)
    ){
        TvLiveRepo(apiHelper)
    }.liveData.cachedIn(viewModelScope)
}