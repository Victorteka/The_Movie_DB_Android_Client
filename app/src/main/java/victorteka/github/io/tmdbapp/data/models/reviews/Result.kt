package victorteka.github.io.tmdbapp.data.models.reviews


import com.google.gson.annotations.SerializedName

data class Result(
    val author: String,
    val content: String,
    val id: String,
    val url: String
)