package victorteka.github.io.tmdbapp.ui.tv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.tv_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.tv.Result
import victorteka.github.io.tmdbapp.utils.Constants

class TvAdapter: PagingDataAdapter<Result, TvAdapter.TvDataViewHolder>(DataDifferentiator) {

    class TvDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onBindViewHolder(holder: TvDataViewHolder, position: Int) {
        holder.itemView.trendingTitle.text = "${getItem(position)?.name}"
        holder.itemView.trendingOverview.text = "${getItem(position)?.overview}"
        holder.itemView.trendingReleaseDate.text = "${getItem(position)?.firstAirDate}"
        Glide.with(holder.itemView.trendingPoster.context).load(Constants.IMAGE_URL+getItem(position)?.posterPath)
            .into(holder.itemView.trendingPoster)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvDataViewHolder {
        return TvDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.tv_item, parent, false)
        )
    }

    object DataDifferentiator: DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

    }

}