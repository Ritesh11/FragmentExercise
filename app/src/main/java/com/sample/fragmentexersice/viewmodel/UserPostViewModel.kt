package com.sample.fragmentexersice.viewmodel

import androidx.lifecycle.ViewModel
import com.sample.fragmentexersice.repository.PostRepository

class UserPostViewModel(private val repository: PostRepository): ViewModel() {
}