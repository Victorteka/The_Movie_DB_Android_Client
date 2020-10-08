package victorteka.github.io.tmdbapp.ui.search.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.searching.Result
import victorteka.github.io.tmdbapp.utils.Constants

class SearchAdapter(private val searchList: ArrayList<Result>): RecyclerView.Adapter<SearchAdapter.SearchDataViewHolder>() {

    class SearchDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(result: Result){
            itemView.movieTitle.text = result.name
            itemView.date.text = result.overview
            Glide.with(itemView.posterImage.context).load(Constants.IMAGE_URL+result.posterPath)
                .into(itemView.posterImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDataViewHolder {
        return SearchDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = searchList.size

    override fun onBindViewHolder(holder: SearchDataViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    fun addList(list: List<Result>){
        searchList.addAll(list)
    }
}