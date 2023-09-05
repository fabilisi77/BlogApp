package com.example.blogapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class HomeScreenViewModel: ViewModel() {
    fun fetchtLatestPosts() = liveData(Dispatchers.IO) {

    }
}