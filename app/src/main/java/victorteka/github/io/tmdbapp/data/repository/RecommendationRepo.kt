package victorteka.github.io.tmdbapp.data.repository

import victorteka.github.io.tmdbapp.data.api.ApiHelper
import javax.inject.Inject

class RecommendationRepo @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getMovieRecommendations(movieId: String) = apiHelper.getMovieRecommendations(movieId)
}