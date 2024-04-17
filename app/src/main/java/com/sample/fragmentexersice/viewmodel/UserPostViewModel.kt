package com.sample.fragmentexersice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.fragmentexersice.model.Albums
import com.sample.fragmentexersice.repository.PostRepository
import kotlinx.coroutines.launch

class UserPostViewModel(private val repository: PostRepository) : ViewModel() {

    var userPost: LiveData<Albums?> = repository.postList


    fun hitPostApi() {
        viewModelScope.launch {
            repository.callPostApi()
        }
    }

}