package victorteka.github.io.tmdbapp.ui.tv.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.trending_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.tv.Result

class TvAdapter: PagingDataAdapter<Result, TvAdapter.TvDataViewHolder>(DataDifferentiator) {

    class TvDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onBindViewHolder(holder: TvDataViewHolder, position: Int) {
        holder.itemView.trendingTitle.text = "${getItem(position)?.name}"
        holder.itemView.trendingOverview.text = "${getItem(position)?.overview}"

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvDataViewHolder {
        return TvDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.trending_item, parent, false)
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