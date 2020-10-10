package victorteka.github.io.tmdbapp.ui.movies.views.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_review_movie.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.reviews.Result
import victorteka.github.io.tmdbapp.ui.movies.adapters.ReviewAdapter
import victorteka.github.io.tmdbapp.ui.movies.viewmodels.MovieReviewViewModel
import victorteka.github.io.tmdbapp.utils.Status


@AndroidEntryPoint
class MovieReviewFragment : Fragment() {

    private lateinit var adapter: ReviewAdapter
    private val viewModel: MovieReviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = this.arguments?.getInt("movieId")
        setupObserver(movieId.toString())
        setupUI()
    }

    private fun setupObserver(id: String) {
        viewModel.fetchReviews(id)
        viewModel.reviews.observe(viewLifecycleOwner,  Observer {
            when(it.status){
                Status.SUCCESS -> {
                    it.data?.let {
                        renderItems(it)
                        reviewsProgresBar.visibility = View.GONE
                    }
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                    reviewsProgresBar.visibility = View.GONE
                }
            }
        })
    }

    private fun renderItems(list: List<Result>) {
        adapter.addData(list)
        adapter.notifyDataSetChanged()
    }

    private fun setupUI() {
        adapter = ReviewAdapter(
            arrayListOf()
        )
        reviewRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        reviewRecyclerview.adapter = adapter
    }
}