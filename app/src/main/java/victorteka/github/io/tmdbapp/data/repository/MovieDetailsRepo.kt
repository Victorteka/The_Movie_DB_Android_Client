package victorteka.github.io.tmdbapp.data.repository

import victorteka.github.io.tmdbapp.data.api.ApiHelper
import javax.inject.Inject

class MovieDetailsRepo @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getMovieDetail(movieId: String) = apiHelper.getMovieDetail(movieId)

}