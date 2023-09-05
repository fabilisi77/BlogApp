package com.example.blogapp.data.remote

import com.example.blogapp.core.Resource
import com.example.blogapp.data.model.Post
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {
    suspend fun getLatestPost(): Resource<List<Post>>{
        val posList = mutableListOf<Post>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("posts").get().await()
        for (post in querySnapshot.documents){
            post.toObject(Post::class.java)?.let {
                posList.add(it)
            }
        }
        return Resource.Success(posList)

    }
}