package victorteka.github.io.tmdbapp.ui.movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.review_item.view.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.reviews.Result

class ReviewAdapter(private val reviews: ArrayList<Result>): RecyclerView.Adapter<ReviewAdapter.ReviewDataViewHolder>() {

    class ReviewDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(result: Result){
            itemView.reviewedBy.text = "Reviewed by: ${result.author}"
            itemView.reviewContent.text = result.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewDataViewHolder {
        return ReviewDataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.review_item, parent, false)
        )
    }

    override fun getItemCount(): Int = reviews.size

    override fun onBindViewHolder(holder: ReviewDataViewHolder, position: Int) {
        holder.bind(reviews[position])
    }

    fun addData(list: List<Result>){
        reviews.addAll(list)
    }
}