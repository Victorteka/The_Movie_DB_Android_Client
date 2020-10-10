package victorteka.github.io.tmdbapp.data.api

import retrofit2.Response
import victorteka.github.io.tmdbapp.data.models.latest.Latest
import victorteka.github.io.tmdbapp.data.models.moviedetails.MovieDetail
import victorteka.github.io.tmdbapp.data.models.reviews.Review
import victorteka.github.io.tmdbapp.data.models.searching.SearchMovie
import victorteka.github.io.tmdbapp.data.models.trending.Trend
import victorteka.github.io.tmdbapp.data.models.tv.LiveShows
import victorteka.github.io.tmdbapp.data.models.upcoming.UpcomingResults
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService): ApiHelper {

    override suspend fun getUpcomingMovie():
            Response<UpcomingResults> = apiService.getUpcomingMovie()

    override suspend fun getLatestMovie():
            Response<Latest> = apiService.getLatestMovie()

    override suspend fun getPopular(): Response<UpcomingResults> = apiService.getPopular()

    override suspend fun getTrending(): Response<Trend> = apiService.getTrending()

    override suspend fun getTvOnAir(): Response<LiveShows> = apiService.getTvOnAir()

    override suspend fun search(query: String)
            : Response<SearchMovie> = apiService.search(query)

    override suspend fun getMovieDetail(movieId: String)
            : Response<MovieDetail> = apiService.getMovieDetail(movieId)

    override suspend fun getMovieReview(movieId: String)
            : Response<Review> = apiService.getMovieReview(movieId)

    override suspend fun getMovieRecommendations(movieId: String)
            : Response<UpcomingResults> = apiService.getMovieRecommendations(movieId)


}