package victorteka.github.io.tmdbapp.ui.movies.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_upcoming_movies.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
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
        upcomingMovieViewModel.upcomingMovies.observe(viewLifecycleOwner, Observer { it ->
            when (it.status) {
                Status.LOADING -> {

                }
                Status.SUCCESS -> {
                    it.data?.let { results ->
                        renderList(results)
                    }
                }
                Status.ERROR -> {

                }
            }
        })
    }

    private fun renderList(list: List<Result>) {
        adapter.addData(list)
        adapter.notifyDataSetChanged()
    }


    private fun setupUI() {
        adapter = UpcomingMovieAdapter(
            arrayListOf()
        )
        upcomingMovieRv.layoutManager = GridLayoutManager(requireContext(), 2)
        upcomingMovieRv.adapter = adapter
    }
}