package victorteka.github.io.tmdbapp.ui.movies.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.utils.Constants

class UpcomingMovieAdapter(private val upcomingMovies: ArrayList<Result>):
    RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingDataViewHolder>() {

    class UpcomingDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(upcomingResults:Result){
            itemView.movieTitle.text = upcomingResults.title
            itemView.date.text = upcomingResults.releaseDate
            Glide.with(itemView.posterImage.context).load(Constants.IMAGE_URL+upcomingResults.posterPath)
                .into(itemView.posterImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingDataViewHolder {
        return UpcomingDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = upcomingMovies.size

    override fun onBindViewHolder(holder: UpcomingDataViewHolder, position: Int) {
        holder.bind(upcomingMovies[position])
    }

    fun addData(list: List<Result>){
        upcomingMovies.addAll(list)
    }
}