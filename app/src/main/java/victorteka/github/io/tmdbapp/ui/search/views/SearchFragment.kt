package victorteka.github.io.tmdbapp.ui.search.views

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*
import victorteka.github.io.tmdbapp.R
import victorteka.github.io.tmdbapp.data.models.searching.Result
import victorteka.github.io.tmdbapp.ui.search.adapters.SearchAdapter
import victorteka.github.io.tmdbapp.ui.search.viewmodels.SearchViewModel


@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var searchView: SearchView
    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        setHasOptionsMenu(true)
        setupUI()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)

        val myActionMenuItem = menu.findItem(R.id.action_search)
        searchView = myActionMenuItem.actionView as SearchView

        searchView.setOnQueryTextListener(
            object: SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    setupObserver()
                    searchViewModel.searchItem(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            }
        )
    }

    private fun setupUI() {
        searchAdapter = SearchAdapter(
            arrayListOf()
        )
        searchRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        searchRecyclerView.adapter = searchAdapter
    }

    private fun setupObserver() {
        searchViewModel.searchList.observe(viewLifecycleOwner, Observer {
            renderItem(it)
        })
    }

    private fun renderItem(list: List<Result>) {
        searchAdapter.addList(list)
        searchAdapter.notifyDataSetChanged()
    }
}