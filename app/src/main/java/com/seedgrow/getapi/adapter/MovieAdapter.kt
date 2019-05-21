package com.seedgrow.getapi.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seedgrow.getapi.R
import com.seedgrow.getapi.glide.GlideApp
import com.seedgrow.getapi.model.Result
import kotlinx.android.synthetic.main.list_movie_item.view.*

class MovieAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var responseMovie: MutableList<Result>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemLayout = R.layout.list_movie_item
        val itemViewProject = LayoutInflater.from(parent.context)
            .inflate(itemLayout, parent, false)
        return MyViewHolder(itemViewProject)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        if (responseMovie != null) {
            return responseMovie?.size!!
        } else return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mResponseMovie = responseMovie?.get(position)
        val context = holder.itemView.context


        val imageMovie = mResponseMovie?.backdropPath

        Log.d("MovieAdapter", imageMovie)

        GlideApp.with(context)
            .load("http://image.tmdb.org/t/p/w185/" + imageMovie)
            .into(holder.itemView.imageView_movie)

        holder.itemView.textView_title_movie.text = mResponseMovie?.title
        holder.itemView.textView_popularity_movie.text = mResponseMovie?.popularity.toString()

    }

    fun setDataMovies(responseMovies: MutableList<Result>?){
        this.responseMovie = responseMovies
        notifyDataSetChanged()
    }
}