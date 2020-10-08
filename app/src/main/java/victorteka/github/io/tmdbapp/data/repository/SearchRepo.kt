package victorteka.github.io.tmdbapp.data.repository

import victorteka.github.io.tmdbapp.data.api.ApiHelper
import javax.inject.Inject

class SearchRepo @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun search(query: String) = apiHelper.search(query)
}