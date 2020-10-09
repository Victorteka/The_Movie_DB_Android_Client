package victorteka.github.io.tmdbapp.ui.movies.views.moviedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.views.MovieDetailsActivity


class MovieDetailsFragment : Fragment() {

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
        Toast.makeText(requireContext(), "$movieId", Toast.LENGTH_LONG).show()
    }
}