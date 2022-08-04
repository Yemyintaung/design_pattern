package com.sbs.android.features.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewbinding.ViewBinding
import com.sbs.android.R
import com.sbs.android.base.BaseFragment
import com.sbs.android.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sbs.android.features.movie.adapter.MovieAdapter
import com.sbs.android.utils.Results
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment : BaseFragment<FragmentMovieBinding>() {

    private val viewModel : MovieViewModel by viewModels()
    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun constructViewBinding(): ViewBinding = FragmentMovieBinding.inflate(layoutInflater)

    override fun init(viewBinding: ViewBinding) {
        viewModel.getMovies("upcoming")
        initUi()
        fetchMovies()
    }

    private fun initUi() {
        getViewBinding().prayScheduleRv.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    private fun fetchMovies() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is Results.Loaded -> onLoaded(state.content)
                        is Results.Error -> renderError(state.throwable)
                        else -> showLoading()
                    }
                }
            }
        }
    }

    private fun onLoaded(state: MovieItemUiState) {
        state.run {
            getViewBinding().cityTv.text = this.data[0].title
            movieAdapter.submitList(this.data)
        }
    }

    private fun showLoading() {
        /*Timber.d("showLoading")*/
    }

    private fun showError(@StringRes stringRes: Int) {
        Toast.makeText(requireContext(), stringRes, Toast.LENGTH_SHORT).show()
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}