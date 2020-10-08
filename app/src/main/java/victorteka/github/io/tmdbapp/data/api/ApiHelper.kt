package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import victorteka.github.io.tmdbapp.data.models.latest.Latest
import victorteka.github.io.tmdbapp.data.models.searching.SearchMovie
import victorteka.github.io.tmdbapp.data.models.trending.Trend
import victorteka.github.io.tmdbapp.data.models.tv.LiveShows
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults

interface ApiHelper {

    suspend fun getUpcomingMovie(): Response<UpcomingResults>

    suspend fun getLatestMovie(): Response<Latest>

    suspend fun getPopular():Response<UpcomingResults>

    suspend fun getTrending(): Response<Trend>

    suspend fun getTvOnAir(): Response<LiveShows>

    suspend fun search(query: String): Response<SearchMovie>
}