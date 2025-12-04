package com.example.roomform.data.repository

import com.example.roomform.data.local.UserDao
import com.example.roomform.data.local.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userDao: UserDao
){

    fun getAllUsers(): Flow<List<UserEntity>> = userDao.getAllUsers()

    suspend fun insertUser(user: UserEntity){
        userDao.insertUser(user)
    }
}