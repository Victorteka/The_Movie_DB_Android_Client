package victorteka.github.io.tmdbapp.ui.movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.utils.Constants

class PopularMovieAdapter: PagingDataAdapter<Result, PopularMovieAdapter.PopularDataViewHolder>(DataDifferntiator) {

    class PopularDataViewHolder(view: View): RecyclerView.ViewHolder(view)

    object DataDifferntiator: DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: PopularDataViewHolder, position: Int) {
        holder.itemView.movieTitle.text = "${getItem(position)?.title}"
        holder.itemView.date.text = "${getItem(position)?.releaseDate}"
        Glide.with(holder.itemView.posterImage.context).load(Constants.IMAGE_URL+getItem(position)?.posterPath)
            .into(holder.itemView.posterImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularDataViewHolder {
        return PopularDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item,parent, false)
        )
    }
}