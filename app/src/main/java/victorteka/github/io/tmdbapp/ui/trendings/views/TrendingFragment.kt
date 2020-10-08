package victorteka.github.io.tmdbapp.ui.trendings.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tranding.*
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.adapters.MoviesLoadStateAdapter
import victorteka.github.io.tmdbapp.ui.trendings.adapters.TrendingAdapter
import victorteka.github.io.tmdbapp.ui.trendings.viewmodels.TrendingMovieViewModel


@AndroidEntryPoint
class TrendingFragment : Fragment() {

    private val viewModel: TrendingMovieViewModel by viewModels()
    private lateinit var trendingAdapter: TrendingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tranding, container, false)
        setupObserver()
        return view
    }

    private fun setupObserver() {
        viewModel.listResult.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                trendingAdapter.submitData(it)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        setupUI()
    }

    private fun setupUI() {
        trendingAdapter = TrendingAdapter()

        trendingAdapter.addLoadStateListener {
            if (it.refresh is LoadState.Loading){
                trendingProgressBar.visibility = View.VISIBLE
            }else{
                trendingProgressBar.visibility = View.GONE
            }
        }

        trendingRV.layoutManager = LinearLayoutManager(requireContext())
        trendingRV.adapter = trendingAdapter

        trendingAdapter.withLoadStateHeaderAndFooter(
            header = MoviesLoadStateAdapter(),
            footer = MoviesLoadStateAdapter()
        )
    }
}