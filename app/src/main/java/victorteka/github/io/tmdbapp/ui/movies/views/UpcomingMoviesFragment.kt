package victorteka.github.io.tmdbapp.ui.movies.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_upcoming_movies.*
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.ui.movies.adapters.MoviesLoadStateAdapter
import victorteka.github.io.tmdbapp.ui.movies.adapters.UpcomingMovieAdapter
import victorteka.github.io.tmdbapp.ui.movies.viewmodels.UpcomingMovieViewModel
import victorteka.github.io.tmdbapp.utils.Status

@AndroidEntryPoint
class UpcomingMoviesFragment : Fragment() {

    private val upcomingMovieViewModel: UpcomingMovieViewModel by viewModels()
    private lateinit var adapter: UpcomingMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_upcoming_movies, container, false)
        setupViewModel()
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupViewModel() {
        upcomingMovieViewModel.listResult.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        })
    }

    private fun setupUI() {
        adapter = UpcomingMovieAdapter()
        adapter.addLoadStateListener {
            if (it.refresh == LoadState.Loading) {
                upcomingMoviePB.visibility = View.VISIBLE
            } else {
                upcomingMoviePB.visibility = View.GONE
            }
        }
        upcomingMovieRv.layoutManager = GridLayoutManager(requireContext(), 2)
        upcomingMovieRv.adapter = adapter

        adapter.withLoadStateHeaderAndFooter(
            header = MoviesLoadStateAdapter(),
            footer = MoviesLoadStateAdapter()
        )

    }
}