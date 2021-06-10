package pe.com.dmorales.moviesapp.movies.features.view.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import pe.com.dmorales.moviesapp.databinding.ItemMoviesBinding
import pe.com.dmorales.moviesapp.movies.domain.entities.MovieSummary


class MoviesAdapter(private val clickListener: MoviesItemClickListener):
    ListAdapter<MovieSummary, MoviesAdapter.NewsViewHolder>(MoviesDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,clickListener)
    }

    class NewsViewHolder private constructor(private val binding : ItemMoviesBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(item: MovieSummary, clickListener: MoviesItemClickListener){
            binding.item = item
            binding.onClickListener = clickListener
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent : ViewGroup) : NewsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemMoviesBinding.inflate(inflater,parent,false)
                return NewsViewHolder(binding)
            }
        }
    }

    class MoviesDiffCallback : DiffUtil.ItemCallback<MovieSummary>(){
        override fun areItemsTheSame(oldItem: MovieSummary, newItem: MovieSummary): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieSummary, newItem: MovieSummary): Boolean {
            return oldItem == newItem
        }

    }

    class MoviesItemClickListener(val clickListener: (movieSummary: MovieSummary)->Unit){
        fun onClick(movieSummary: MovieSummary) = clickListener(movieSummary)
    }

}
