package victorteka.github.io.tmdbapp.data.models.tv


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("original_name")
    val originalName: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    val name: String,
    val popularity: Double,
    @SerializedName("origin_country")
    val originCountry: List<String>,
    @SerializedName("vote_count")
    val voteCount: Int,
    @SerializedName("first_air_date")
    val firstAirDate: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    val id: Int,
    @SerializedName("vote_average")
    val voteAverage: Double,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String
)