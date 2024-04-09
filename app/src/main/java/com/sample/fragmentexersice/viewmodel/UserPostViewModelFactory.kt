package com.sample.fragmentexersice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.fragmentexersice.repository.PostRepository
import com.sample.fragmentexersice.repository.RegisterRepository

class UserPostViewModelFactory (private val registerRepository: PostRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return UserPostViewModel(registerRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}