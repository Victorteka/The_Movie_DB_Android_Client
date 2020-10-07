package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults

interface ApiHelper {
    suspend fun getUpcomingMovie(): Response<UpcomingResults>
}