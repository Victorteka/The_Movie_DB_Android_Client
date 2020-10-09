package victorteka.github.io.tmdbapp.data.models.upcoming


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UpcomingResults(
    val results: List<Result>
) : Parcelable