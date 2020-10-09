package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import victorteka.github.io.tmdbapp.data.models.latest.Latest
import victorteka.github.io.tmdbapp.data.models.moviedetails.MovieDetail
import victorteka.github.io.tmdbapp.data.models.searching.SearchMovie
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

    @GET("search/multi")
    suspend fun search(@Query("query") query: String): Response<SearchMovie>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: String): Response<MovieDetail>
}