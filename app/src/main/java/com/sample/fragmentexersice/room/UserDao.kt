package com.sample.fragmentexersice.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sample.fragmentexersice.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long

    @Update
    suspend fun updateUser(users: User): Int

    @Delete
    suspend fun deleteUser(users: User): Int

    @Query("DELETE FROM registered_user_table")
    suspend fun deleteAllUser(): Int

    @Query("SELECT * FROM registered_user_table")
    fun getUser(): LiveData<List<User>>

}