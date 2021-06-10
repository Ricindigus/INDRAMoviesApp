package pe.com.dmorales.moviesapp.movies.features.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import pe.com.dmorales.moviesapp.databinding.FragmentDetailBinding
import pe.com.dmorales.moviesapp.movies.features.view.main.MainViewModel

class DetailFragment : Fragment() {
    private lateinit var mBinding: FragmentDetailBinding
    private val mViewModel by viewModel<DetailViewModel>()
    private val linkViewModel by sharedViewModel<MainViewModel>()
    private lateinit var navController: NavController
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = mViewModel
        subscribeObservers()
        retrieveArguments()
    }

    private fun retrieveArguments() {
        mViewModel.setMovieData(args.movieData)
    }

    private fun subscribeObservers() {}
}