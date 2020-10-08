package victorteka.github.io.tmdbapp.ui.trendings.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.trending_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.trending.Result
import victorteka.github.io.tmdbapp.utils.Constants

class TrendingAdapter: PagingDataAdapter<Result, TrendingAdapter.TrendingDataViewHolder>(DataDifferntiator) {

    class TrendingDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingDataViewHolder {
        Log.d("TAG", "====Layout created====")
        return TrendingDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.trending_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TrendingDataViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: ====start binding ====")
        holder.itemView.trendingOverview.text = "${getItem(position)?.overview}"
        holder.itemView.trendingTitle.text = "${getItem(position)?.title}"
        holder.itemView.trendingReleaseDate.text = "${getItem(position)?.releaseDate}"
        holder.itemView.trendingMediaType.text = "${getItem(position)?.mediaType}"
        Glide.with(holder.itemView.trendingPoster.context).load(Constants.IMAGE_URL+getItem(position)?.posterPath)
            .into(holder.itemView.trendingPoster)
        Log.d("TAG", "onBindViewHolder: ====Finish binding ====")
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