package com.example.movieapp.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_movies")   //in this way we are saying to android studio to create table
data class Movie(
    @PrimaryKey
@SerializedName("id") //check for the id inside the json file
    val Movieid: Int,

@SerializedName("overview")
    val overview: String,

@SerializedName("poster_path")
    val posterPath:String,

//if we do not use serializedname we have to hoewer it given to us
    val release_date: String,

    val title: String

)
