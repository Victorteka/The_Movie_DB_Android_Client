package victorteka.github.io.tmdbapp.ui.movies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.databinding.MovieItemBinding
import victorteka.github.io.tmdbapp.utils.Constants

class UpcomingMovieAdapter(private val clickListener: UpcomingMovieListener)
    : PagingDataAdapter<Result, UpcomingMovieAdapter.UpcomingDataViewHolder>(DataDifferntiator){

    class UpcomingDataViewHolder(private val binding: MovieItemBinding): ViewHolder(binding.root){
        fun bind(movie: Result, clickListener: UpcomingMovieListener){
            binding.movie = movie
            binding.clickListener = clickListener
            Glide.with(binding.posterImage.context).load(Constants.IMAGE_URL+movie.posterPath)
                .into(binding.posterImage)
        }

        companion object{
            fun from(parent: ViewGroup): UpcomingDataViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
                return UpcomingDataViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingDataViewHolder {
        return UpcomingDataViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UpcomingDataViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, clickListener) }
    }

    object DataDifferntiator: DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }
}

class UpcomingMovieListener(val clickListener: (movie: Result) -> Unit){
    fun onClick(movie: Result) = clickListener(movie)
}