package victorteka.github.io.tmdbapp.data.repository

import victorteka.github.io.tmdbapp.data.api.ApiHelper
import javax.inject.Inject

class MovieReviewRepo @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getMovieReviews(movieId: String) = apiHelper.getMovieReview(movieId)
}