package com.sample.fragmentexersice.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.fragmentexersice.Event
import com.sample.fragmentexersice.model.User
import com.sample.fragmentexersice.repository.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel(private val repository: RegisterRepository) : ViewModel() {
    val user = repository.user

    var nameErrorMsg: ObservableField<String> = ObservableField()
    var emailErrorMsg: ObservableField<String> = ObservableField()
    var catErrorMsg: ObservableField<String> = ObservableField()
    var techErrorMsg: ObservableField<String> = ObservableField()

    val name = MutableLiveData<String?>()
    val email = MutableLiveData<String?>()
    val position = MutableLiveData<String?>()
    val tech = MutableLiveData<String?>()
    private val _message = MutableLiveData<Event<String>>()

    val message: LiveData<Event<String>>
        get() = _message

    fun saveUser() {
        viewModelScope.launch(Dispatchers.Main) {
            val users: ArrayList<User> = ArrayList()
            Log.i("Ritesh Tag", "We are is -> ${Thread.currentThread().name}")
            if (name.value?.isEmpty()==true) {
                nameErrorMsg.set("Please Enter Name")
            } else if (email.value?.isEmpty()==true) {
                emailErrorMsg.set("Please Enter Email")
            } else if(tech.value?.isEmpty() == true){
                techErrorMsg.set("Please enter Tech")
            } else {
                val inputName = name.value
                val inputEmail = email.value
                val inputTech = tech.value
                addUser(User(0, inputName, inputEmail, inputTech))
                name.value = ""
                email.value = ""
                tech.value = ""
            }
        }
    }

    fun updateUser(user: User) = viewModelScope.launch(IO) {
        val numberOfRows = repository.updateUser(user)
        withContext(Main) {
            if (numberOfRows > 0) {
                _message.value = Event("Successfully updated")
            } else {
                _message.value = Event("Update Failed")
            }
        }
    }

    fun deleteAllUsers() = viewModelScope.launch(IO) {
        repository.deleteAllUser()
    }

    fun addUser(user: User) = viewModelScope.launch(IO) {
        val newRowId = repository.insertUser(user)
        withContext(Main) {
            if (newRowId > -1) {
                _message.value = Event("Successfully Inserted")
            } else {
                _message.value = Event("Insert Failed")
            }

        }
    }

    fun deleteUser(user: User) = viewModelScope.launch(IO) {
        val numberOfRowsDeleted = repository.deleteUser(user)
        withContext(Main){
            if(numberOfRowsDeleted>1){
                _message.value = Event("Successfully Deleted")
            }else{
                _message.value = Event("Delete Failed")
            }
        }
    }

    fun deleteAllUser() = viewModelScope.launch(IO) {
        val numberOfRowsDeleted = repository.deleteAllUser()
        withContext(Main){
            if(numberOfRowsDeleted>1){
                _message.value = Event("Successfully Deleted All")
            }else{
                _message.value = Event("Delete Failed")
            }
        }
    }

}