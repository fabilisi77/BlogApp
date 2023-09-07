package com.example.blogapp.domain.home

import com.example.blogapp.core.Result
import com.example.blogapp.data.model.Posts

interface HomeScreenRepo {
    suspend fun getLatestPost(): Result<List<Posts>>
}