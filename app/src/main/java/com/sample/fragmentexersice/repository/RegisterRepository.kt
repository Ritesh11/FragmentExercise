package com.sample.fragmentexersice.repository

import com.sample.fragmentexersice.model.User
import com.sample.fragmentexersice.room.UserDao

class RegisterRepository(private val dao: UserDao) {

    val user = dao.getUser()

    suspend fun insertUser(user: User): Long {
       return dao.insertUser(user)
    }

    suspend fun updateUser(user: User): Int {
        return dao.updateUser(user)
    }

    suspend fun deleteUser(user: User): Int {
        return dao.deleteUser(user)
    }

    suspend fun deleteAllUser(): Int {
        return dao.deleteAllUser()
    }

}