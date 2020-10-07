package victorteka.github.io.tmdbapp.ui.movies.views

import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_popular_movies.*
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.adapters.MoviesLoadStateAdapter
import victorteka.github.io.tmdbapp.ui.movies.adapters.PopularMovieAdapter
import victorteka.github.io.tmdbapp.ui.movies.viewmodels.PopularMovieViewModel


@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {

    private val popularViewModel: PopularMovieViewModel by viewModels()
    private lateinit var adapter: PopularMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_popular_movies, container, false)
        setupObserver()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        adapter = PopularMovieAdapter()
        adapter.addLoadStateListener {
            if (it.refresh is LoadState.Loading){

            }else{

            }
        }
        popularMovieRv.layoutManager = GridLayoutManager(requireContext(), 2)
        popularMovieRv.adapter = adapter

        adapter.withLoadStateHeaderAndFooter(
            header = MoviesLoadStateAdapter(),
            footer = MoviesLoadStateAdapter()
        )
    }

    private fun setupObserver() {
        popularViewModel.listResults.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                adapter.submitData(it)
            }
        })
    }

}