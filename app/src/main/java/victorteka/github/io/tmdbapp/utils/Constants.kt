package victorteka.github.io.tmdbapp.utils

import victorteka.github.io.tmdbapp.BuildConfig


class Constants {
    companion object{
        const val API_KEY = BuildConfig.TMDB_API_KEY
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }
}