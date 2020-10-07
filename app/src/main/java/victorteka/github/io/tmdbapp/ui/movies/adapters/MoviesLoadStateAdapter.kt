package victorteka.github.io.tmdbapp.ui.movies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.paging_footer.view.*
import victorteka.github.io.tmdbapp.R

class MoviesLoadStateAdapter(): LoadStateAdapter<MoviesLoadStateAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onBindViewHolder(holder: ViewHolder, loadState: LoadState) {
        if (loadState == LoadState.Loading){
            holder.itemView.footerLayout.visibility = View.VISIBLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.paging_footer, parent, false)
        )
    }

}