package com.example.blogapp.domain

import com.example.blogapp.core.Resource
import com.example.blogapp.data.model.Posts

interface HomeScreenRepo {
    suspend fun getLatestPost(): Resource<List<Posts>>
}