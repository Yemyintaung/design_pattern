package com.sbs.android.features.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sbs.android.databinding.LayoutMovieBinding
import com.sbs.android.features.movie.model.MovieUiModel

class MovieAdapter :
    ListAdapter<MovieUiModel, MovieAdapter.MovieViewHolder>(MovieDiffUtilCallback) {

    private val praySchedules: ArrayList<MovieUiModel> = ArrayList()
    private lateinit var context: Context

    class MovieViewHolder(binding: LayoutMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        val name = binding.prayNameTv
        val time = binding.prayTimeTv

        public fun bindData(model: MovieUiModel) {
            name.text = model.title
            time.text = model.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        context = parent.context
        val viewBinding = LayoutMovieBinding.inflate(LayoutInflater.from(parent.context))
        return MovieViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
        holder.bindData(getItem(position))

    object MovieDiffUtilCallback : DiffUtil.ItemCallback<MovieUiModel>() {
        override fun areItemsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: MovieUiModel, newItem: MovieUiModel): Boolean =
            oldItem == newItem

    }
}