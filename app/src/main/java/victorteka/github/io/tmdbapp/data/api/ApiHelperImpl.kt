package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import victorteka.github.io.tmdbapp.data.models.latest.Latest
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {

    override suspend fun getUpcomingMovie():
            Response<UpcomingResults> = apiService.getUpcomingMovie()

    override suspend fun getLatestMovie():
            Response<Latest> = apiService.getLatestMovie()

    override suspend fun getPopular(): Response<UpcomingResults> = apiService.getPopular()
}