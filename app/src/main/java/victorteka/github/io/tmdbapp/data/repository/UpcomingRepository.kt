package victorteka.github.io.tmdbapp.data.repository

import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.api.ApiHelperImpl
import javax.inject.Inject

class UpcomingRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getUpcomingMovie() = apiHelper.getUpcomingMovie()

}