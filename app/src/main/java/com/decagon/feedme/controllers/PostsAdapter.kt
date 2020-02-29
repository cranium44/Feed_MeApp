package com.decagon.feedme.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.decagon.feedme.R
import com.decagon.feedme.models.Post

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    var data = arrayListOf(
        Post(
            "Andy Akpan",
            "Jollof Rice and Stew",
            "Medium",
            203,
            "1h 15m"
        ),
        Post(
            "Jones Ogolo",
            "Fried Rice and Beef Sauce",
            "Hard",
            203,
            "1h 45m"
        ),
        Post(
            "Chukwudi Ndimneze",
            "Tea and Bread",
            "Easy",
            713,
            "15m"
        )
    )

    class PostsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeName = view.findViewById<TextView>(R.id.recipe_name_display)
        val poster = view.findViewById<TextView>(R.id.poster_name)
        val likes = view.findViewById<TextView>(R.id.likes_display)
        val time = view.findViewById<TextView>(R.id.time_duration)
        val difficulty = view.findViewById<TextView>(R.id.difficulty_display)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_row, parent, false)
        return PostsViewHolder((view))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val cur = data[position]
        holder.difficulty.text = cur.recipe_difficulty
        holder.poster.text = cur.name
        holder.likes.text = cur.likes.toString()
        holder.recipeName.text = cur.recipeName
        holder.time.text = cur.duration
    }
}