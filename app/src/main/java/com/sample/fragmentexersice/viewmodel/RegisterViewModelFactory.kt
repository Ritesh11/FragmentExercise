package com.sample.fragmentexersice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.fragmentexersice.repository.RegisterRepository

class RegisterViewModelFactory(private val registerRepository: RegisterRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)){
            return RegisterViewModel(registerRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model")
    }
}