package victorteka.github.io.tmdbapp.ui.movies.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.adapters.MovieViewPagerAdapter

class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        setupViewPager()
    }

    private fun setupViewPager() {
        val adapter = activity?.supportFragmentManager?.let {
            MovieViewPagerAdapter(supportFragmentManager = it)
        }
        adapter?.addFragment(UpcomingMoviesFragment(), "Upcoming")
        adapter?.addFragment(LatestMoviesFragment(), "Latest")
        adapter?.addFragment(PopularMoviesFragment(), "Popular")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}