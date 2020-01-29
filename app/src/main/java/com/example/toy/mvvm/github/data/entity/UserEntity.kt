package com.example.toy.mvvm.github.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserEntity(
  @PrimaryKey
  val login: String,
  val name: String?,
  val bio: String?,
  val isBookmark: Boolean? = false
)