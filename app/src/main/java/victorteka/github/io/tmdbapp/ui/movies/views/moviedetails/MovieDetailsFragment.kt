package victorteka.github.io.tmdbapp.ui.movies.views.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie_details.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.viewmodels.MovieDetailsViewModel

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private val movieViewModel: MovieDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = this.arguments?.getInt("movieId")
        setupObserver(movieId.toString())
    }

    private fun setupObserver(id: String) {
        movieViewModel.fetchMovieDetails(id)
        movieViewModel.movieDetails.observe(viewLifecycleOwner, Observer {
            movieDetailsOverview.text = it.overview
        })
    }
}