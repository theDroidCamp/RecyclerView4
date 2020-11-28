package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_captamerica_list.view.*

class MoviesRecyclerAdapter(val screen : List<Movies>): RecyclerView.Adapter<MoviesRecyclerAdapter
.MovieViewHolder>(){



    class MovieViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_captamerica_list,parent,false)
        )
    }
    override fun getItemCount() = screen.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val binder = screen[position]
        holder.view.title.text = binder.title
        holder.view.rating.text = binder.rating.toString()

//        Glide.with(holder.view.context)
//            .load

    }



    }

