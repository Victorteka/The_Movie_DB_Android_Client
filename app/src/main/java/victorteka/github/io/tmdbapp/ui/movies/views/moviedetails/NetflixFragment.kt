package victorteka.github.io.tmdbapp.ui.movies.views.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_rate.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.viewmodels.MovieDetailsViewModel


@AndroidEntryPoint
class NetflixFragment : Fragment() {

    private val movieViewModel: MovieDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movieId = this.arguments?.getInt("movieId")
        setupObserver(movieId.toString())
    }

    private fun setupObserver(id: String) {
        movieViewModel.fetchMovieDetails(id)
        movieViewModel.movieDetails.observe(viewLifecycleOwner, Observer {
            netFixHomePage.webViewClient = object: WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    if (url != null) {
                        view?.loadUrl(url)
                    }
                    return true
                }
            }
            netFixHomePage.loadUrl(it.homepage)
        })
    }
}