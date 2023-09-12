package com.example.blogapp.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.blogapp.core.BaseViewHolder
import com.example.blogapp.data.model.Posts
import com.example.blogapp.databinding.PostItemViewBinding

class HomeScreenAdapter(private val postList: List<Posts>) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            PostItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeScreenViewHolder(itemBinding, parent.context)

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is HomeScreenViewHolder -> holder.bind(postList[position])
        }
    }

    override fun getItemCount(): Int = postList.size

    private inner class HomeScreenViewHolder (
        val binding: PostItemViewBinding,
        val context: Context
    ): BaseViewHolder<Posts>(binding.root) {
        override fun bind(item: Posts) {
            Glide.with(context).load(item.post_image).into(binding.postImage)
            Glide.with(context).load(item.profile_picture).into(binding.profilePicture)
            binding.profileName.text = item.profile_name
            binding.postDescription.text = if (item.post_description.isEmpty())"" else item.post_description
            binding.postTimestamp.text = "hace 2 horas"
        }
    }
}