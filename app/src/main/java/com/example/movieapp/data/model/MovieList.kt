package com.example.movieapp.data.model
import com.google.gson.annotations.SerializedName
class MovieList(

    @SerializedName("results")
    val movie: List<Movie>
)