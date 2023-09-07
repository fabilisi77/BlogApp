package com.example.blogapp.data.remote.home

import com.example.blogapp.core.Result
import com.example.blogapp.data.model.Posts
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDataSource {
    suspend fun getLatestPost(): Result<List<Posts>> {
        val posList = mutableListOf<Posts>()
        val querySnapshot = FirebaseFirestore.getInstance().collection("posts").get().await()
        for (posts in querySnapshot.documents){
            posts.toObject(Posts::class.java)?.let {
                posList.add(it)
            }
        }
        return Result.Success(posList)

    }
}