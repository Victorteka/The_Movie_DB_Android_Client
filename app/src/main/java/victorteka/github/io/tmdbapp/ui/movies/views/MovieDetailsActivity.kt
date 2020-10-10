package victorteka.github.io.tmdbapp.ui.movies.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_movie_details.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import victorteka.github.io.tmdbapp.ui.movies.adapters.MovieDetailsViewPager
import victorteka.github.io.tmdbapp.ui.movies.views.moviedetails.MovieDetailsFragment
import victorteka.github.io.tmdbapp.ui.movies.views.moviedetails.MovieReviewFragment
import victorteka.github.io.tmdbapp.ui.movies.views.moviedetails.NetflixFragment
import victorteka.github.io.tmdbapp.ui.movies.views.moviedetails.RecommendationFragment
import victorteka.github.io.tmdbapp.utils.Constants

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        setSupportActionBar(toolbar)

        val bundle = intent.getBundleExtra("movieBundle")
        var movie = bundle!!.getParcelable<Result>("movieSelected")!!
        toolbar_layout.title = movie.title
        Glide.with(movieDetailsImage.context).load(Constants.IMAGE_URL+movie.posterPath)
            .into(movieDetailsImage)
        //Pass id to fragments
        val fragmentBundle = Bundle()
        fragmentBundle.putInt("movieId", movie.id)
        setupViewPager(fragmentBundle)
    }

    private fun setupViewPager(bundle: Bundle) {
        val adapter = MovieDetailsViewPager(supportFragmentManager)
        //pass movie id through bundle
        val movieDetailsFragment = MovieDetailsFragment()
        movieDetailsFragment.arguments = bundle
        adapter.addFragment(movieDetailsFragment, "Details")

        val movieReviewFragment = MovieReviewFragment()
        movieReviewFragment.arguments = bundle
        adapter.addFragment(movieReviewFragment, "Reviews")

        val netflixFragment = NetflixFragment()
        netflixFragment.arguments = bundle
        adapter.addFragment(netflixFragment, "Netflix")

        val recommendationFragment = RecommendationFragment()
        recommendationFragment.arguments = bundle
        adapter.addFragment(recommendationFragment, "Recommendation")

        movieDetailsViewPager.adapter = adapter
        movieDetailsTabs.setupWithViewPager(movieDetailsViewPager)


    }
}