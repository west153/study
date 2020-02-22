package com.example.toy.mvvm.github.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.toy.mvvm.github.data.dao.UserDao
import com.example.toy.mvvm.github.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class GithubDataBase : RoomDatabase() {
  abstract fun userDao(): UserDao
}