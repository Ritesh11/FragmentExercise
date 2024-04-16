package com.sample.fragmentexersice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.fragmentexersice.repository.PostRepository

class UserPostViewModelFactory (private val postRepository: PostRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserPostViewModel::class.java)){
            return UserPostViewModel(postRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}