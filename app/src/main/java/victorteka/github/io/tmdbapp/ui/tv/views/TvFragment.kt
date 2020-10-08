package victorteka.github.io.tmdbapp.ui.tv.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tv.*
import kotlinx.coroutines.launch
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.ui.movies.adapters.MoviesLoadStateAdapter
import victorteka.github.io.tmdbapp.ui.tv.adapters.TvAdapter
import victorteka.github.io.tmdbapp.ui.tv.viewmodels.TvViewModel

@AndroidEntryPoint
class TvFragment : Fragment() {

    private val tvViewModel: TvViewModel by viewModels()
    private lateinit var tvAdapter: TvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tv, container, false)
        setupObserver()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        setupUI()
    }

    private fun setupUI() {
        tvAdapter = TvAdapter()
        tvRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        tvRecyclerView.adapter = tvAdapter

        tvAdapter.addLoadStateListener {
            if (it.refresh is LoadState.Loading){
                tvProgressBar.visibility = View.VISIBLE
            }else{
                tvProgressBar.visibility = View.GONE
            }
        }

        tvAdapter.withLoadStateHeaderAndFooter(
            header = MoviesLoadStateAdapter(),
            footer = MoviesLoadStateAdapter()
        )
    }

    private fun setupObserver() {
        tvViewModel.tvResult.observe(viewLifecycleOwner, Observer {
            lifecycleScope.launch {
                tvAdapter.submitData(it)
            }
        })
    }
}