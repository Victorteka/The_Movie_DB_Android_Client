package victorteka.github.io.tmdbapp.ui.movies.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_latest_movies.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.viewmodels.LatestMovieViewModel
import victorteka.github.io.tmdbapp.utils.Constants
import victorteka.github.io.tmdbapp.utils.Status

@AndroidEntryPoint
class LatestMoviesFragment : Fragment() {

    private val viewModel: LatestMovieViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_latest_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.latestMovie.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    latestMovie.visibility = View.VISIBLE
                    it.data?.let { movie ->
                        latestMovieTitle.text = movie.title
                        Glide.with(latestMoviePoster.context).load(Constants.IMAGE_URL+movie.posterPath)
                            .into(latestMoviePoster)
                        movieOverview.text = movie.overview
                    }
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                    latestMovie.visibility = View.GONE
                }
            }
        })
    }

}