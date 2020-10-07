package victorteka.github.io.tmdbapp.data.repository

import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.api.ApiService
import victorteka.github.io.tmdbapp.utils.Constants
import javax.inject.Inject

class LatestRepo @Inject constructor(private val apiHelper: ApiHelper){

    suspend fun getLatestMovie() = apiHelper.getLatestMovie()
}