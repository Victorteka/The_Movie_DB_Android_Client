package victorteka.github.io.tmdbapp.data.models.moviedetails


import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    val id: Int,
    val name: String,
    @SerializedName("origin_country")
    val originCountry: String,
    @SerializedName("logo_path")
    val logoPath: String
)