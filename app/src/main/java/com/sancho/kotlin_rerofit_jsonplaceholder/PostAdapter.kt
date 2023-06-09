package com.sancho.kotlin_rerofit_jsonplaceholder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sancho.kotlin_rerofit_jsonplaceholder.model.Post
import com.sancho.kotlin_rerofit_jsonplaceholder.model.PostsPhotoItem

class PostAdapter constructor(
    val context: Context,
    val arrayList: ArrayList<PostsPhotoItem>
):RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    class PostViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        val textView:TextView=itemview.findViewById(R.id.textviewresp)
        val imageView:ImageView=itemview.findViewById(R.id.imageviewresp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recyclerview_item,parent,false)
        return PostViewHolder(view)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.textView.text="${arrayList.get(position).title }"
        Glide.with(context).load(arrayList.get(position).url).into(holder.imageView)
    }

    override fun getItemCount(): Int =arrayList.size


}