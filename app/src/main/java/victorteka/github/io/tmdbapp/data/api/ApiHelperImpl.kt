package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {

    override suspend fun getUpcomingMovie(apiKey: String):
            Response<UpcomingResults> = apiService.getUpcomingMovie(apiKey)
}