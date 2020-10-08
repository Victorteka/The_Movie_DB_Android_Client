package victorteka.github.io.tmdbapp.data.models.trending


import com.google.gson.annotations.SerializedName

data class Result(
    val id: Int,
    val video: Boolean,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("vote_average")
    val voteAverage: Double,
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val adult: Boolean,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    val popularity: Double,
    @SerializedName("media_type")
    val mediaType: String
)