package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults

interface ApiService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(
        @Query("api_key") apiKey: String,
        @Query("page") pageNumber: Int): Response<UpcomingResults>
}