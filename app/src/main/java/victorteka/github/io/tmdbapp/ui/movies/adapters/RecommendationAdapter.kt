package victorteka.github.io.tmdbapp.ui.movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recommend_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.utils.Constants

class RecommendationAdapter(private val recommendations: ArrayList<Result>):
    RecyclerView.Adapter<RecommendationAdapter.RecommendDataViewHolder>() {

    class RecommendDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(recommend: Result){
            Glide.with(itemView.posterImage.context).load(Constants.IMAGE_URL+recommend.posterPath)
                .into(itemView.posterImage)
            itemView.movieTitle.text = recommend.title
            itemView.date.text = recommend.releaseDate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendDataViewHolder {
        return RecommendDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recommend_item, parent, false)
        )
    }

    override fun getItemCount(): Int = recommendations.size

    override fun onBindViewHolder(holder: RecommendDataViewHolder, position: Int) {
        holder.bind(recommendations[position])
    }

    fun addData(list: List<Result>){
        recommendations.addAll(list)
    }
}