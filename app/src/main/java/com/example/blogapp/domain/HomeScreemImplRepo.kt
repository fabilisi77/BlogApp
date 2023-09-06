package com.example.blogapp.domain

import com.example.blogapp.core.Resource
import com.example.blogapp.data.model.Posts
import com.example.blogapp.data.remote.HomeScreenDataSource

class HomeScreenImplRepo(private val dataSource: HomeScreenDataSource):HomeScreenRepo {
    override suspend fun getLatestPost(): Resource<List<Posts>> = dataSource.getLatestPost()
}