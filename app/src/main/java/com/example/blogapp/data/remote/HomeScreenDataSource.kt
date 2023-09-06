package com.example.blogapp.data.remote

import com.example.blogapp.core.Resource
import com.example.blogapp.data.model.Posts
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {
    suspend fun getLatestPost(): Resource<List<Posts>>{
        val posList = mutableListOf<Posts>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("posts").get().await()
        for (posts in querySnapshot.documents){
            posts.toObject(Posts::class.java)?.let {
                posList.add(it)
            }
        }
        return Resource.Success(posList)

    }
}