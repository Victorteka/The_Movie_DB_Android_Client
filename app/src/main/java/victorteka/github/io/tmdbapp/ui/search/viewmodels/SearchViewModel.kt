package victorteka.github.io.tmdbapp.ui.search.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.models.searching.Result

class SearchViewModel @ViewModelInject constructor(private val apiHelper: ApiHelper): ViewModel() {

    private val _searchList = MutableLiveData<List<Result>>()
    val searchList: LiveData<List<Result>>
        get() = _searchList

    fun searchItem(query: String) {
        viewModelScope.launch {
          val results =  apiHelper.search(query)
            _searchList.postValue(results.body()?.results)
        }
    }
}