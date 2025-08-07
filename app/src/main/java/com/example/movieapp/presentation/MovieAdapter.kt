package com.example.movieapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.model.Movie
import com.example.movieapp.databinding.ListItemBinding

class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() { //connecting layout xml and data

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>){

        movieList.clear() //to avaoid duplicate
        movieList.addAll(movies)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bind(movieList[position])
    }
    class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            binding.descTextView.text = movie.overview


            val posterURL = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .placeholder(android.R.drawable.ic_menu_gallery)  // 🟡 basic placeholder
                .error(android.R.drawable.ic_menu_report_image)   // 🔴 fallback if image fails
                .into(binding.imageView)
        }

    }
}