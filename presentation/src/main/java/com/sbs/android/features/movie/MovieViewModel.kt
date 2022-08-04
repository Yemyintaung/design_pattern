package com.sbs.android.features.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sbs.android.features.movie.mapper.MovieUiModelMapper.toUiModel
import com.sbs.android.features.movie.model.MovieUiModel
import com.sbs.android.utils.Results
import com.sbs.android.utils.TimeUtil
import com.sbs.domain.movie.model.MovieRequest
import com.sbs.domain.movie.usecase.GetMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getMovie: GetMovie
) : ViewModel() {

    private val _uiState = MutableStateFlow<Results<MovieItemUiState>>(Results.Empty)
    public val uiState: StateFlow<Results<MovieItemUiState>> = _uiState

    fun getMovies(category: String) {
        _uiState.value = Results.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val requestParam = MovieRequest(category)
                val result = getMovie.execute(requestParam)

                _uiState.value = Results.Loaded(MovieItemUiState(result.toUiModel()))
            } catch (error: Exception) {
                _uiState.value = Results.Error(error)
                /*_uiState.value = Results.Error(ExceptionParser.getMessage(error))*/
            }
        }
    }

    private fun getTodayDate() = TimeUtil.getDateFormatted(Date())
}