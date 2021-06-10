package pe.com.dmorales.moviesapp.movies.features.view.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.dmorales.moviesapp.databinding.FragmentMoviesBinding
import pe.com.dmorales.moviesapp.movies.domain.entities.MovieSummary
import pe.com.dmorales.moviesapp.movies.features.view.main.MainViewModel


class MoviesFragment : Fragment() {
    private lateinit var mBinding: FragmentMoviesBinding
    private val mViewModel by viewModel<MoviesViewModel>()
    private val linkViewModel by sharedViewModel<MainViewModel>()
    private lateinit var navController: NavController
    private var adapter : MoviesAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mBinding = FragmentMoviesBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
        setUpRecycler()
        subscribeObservers()
    }

    private fun setUpRecycler() {
        adapter = MoviesAdapter(MoviesAdapter.MoviesItemClickListener {
                movie: MovieSummary -> mViewModel.onClickMoviesItem(movie)
        })
        mBinding.rvMoviesList.adapter = adapter
    }

    private fun subscribeObservers() {
        mViewModel.moviesList.observe(viewLifecycleOwner){ list ->
            if (list != null){
                adapter?.submitList(list)
            }
        }

        mViewModel.dataMoviesItemDetail.observe(viewLifecycleOwner) { fields ->
            fields?.let {
                goToMovieDetail(it)
                mViewModel.onDataMoviesItemClicked()
            }
        }
    }

    private fun goToMovieDetail(movieSummary: MovieSummary) {
        val action = MoviesFragmentDirections.actionMoviesFragmentToDetailFragment(movieSummary)
        navController.navigate(action)
    }

}