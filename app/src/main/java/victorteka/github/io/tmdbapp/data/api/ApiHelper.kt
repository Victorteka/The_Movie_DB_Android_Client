package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import retrofit2.http.Query
import victorteka.github.io.tmdbapp.data.models.latest.Latest
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults

interface ApiHelper {

    suspend fun getUpcomingMovie(): Response<UpcomingResults>

    suspend fun getLatestMovie(): Response<Latest>
}