package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import victorteka.github.io.tmdbapp.data.models.latest.Latest
import victorteka.github.io.tmdbapp.data.models.trending.Trend
import victorteka.github.io.tmdbapp.data.models.tv.LiveShows
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults

interface ApiService {

    @GET("movie/upcoming?page=1")
    suspend fun getUpcomingMovie(): Response<UpcomingResults>

    @GET("movie/latest")
    suspend fun getLatestMovie(): Response<Latest>

    @GET("movie/popular")
    suspend fun getPopular():Response<UpcomingResults>

    @GET("trending/all/day")
    suspend fun getTrending(): Response<Trend>

    @GET("tv/on_the_air")
    suspend fun getTvOnAir(): Response<LiveShows>
}