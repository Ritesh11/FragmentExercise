package com.sample.fragmentexersice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.fragmentexersice.model.Posts
import com.sample.fragmentexersice.repository.PostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Response

class UserPostViewModel(private val repository: PostRepository) : ViewModel() {

    var userPost: LiveData<Posts?> = repository.postList


    fun hitPostApi() {
        viewModelScope.launch {
            repository.callPostApi()
        }
    }

}