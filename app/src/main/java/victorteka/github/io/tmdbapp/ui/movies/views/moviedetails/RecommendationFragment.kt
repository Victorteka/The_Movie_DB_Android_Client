package victorteka.github.io.tmdbapp.ui.movies.views.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_recommendation.*
import kotlinx.android.synthetic.main.fragment_review_movie.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.ui.movies.adapters.RecommendationAdapter
import victorteka.github.io.tmdbapp.ui.movies.viewmodels.RecommendationViewModel
import victorteka.github.io.tmdbapp.utils.Status


@AndroidEntryPoint
class RecommendationFragment : Fragment() {

    private val viewModel: RecommendationViewModel by viewModels()
    private lateinit var adapter: RecommendationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommendation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = this.arguments?.getInt("movieId")
        setupObserver(movieId.toString())
        setupUi()
    }

    private fun setupObserver(id: String) {
        viewModel.fetchRecommendations(id)
        viewModel.recommendations.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    it.data?.let {
                        renderItems(it)
                        recommendProgressBar.visibility = View.GONE
                    }
                }
                Status.LOADING -> {
                    recommendProgressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                    recommendProgressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun renderItems(list: List<Result>) {
        adapter.addData(list)
        adapter.notifyDataSetChanged()
    }

    private fun setupUi() {
        adapter = RecommendationAdapter(
            arrayListOf()
        )
        recommendRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recommendRecyclerView.adapter = adapter
    }
}