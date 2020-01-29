package com.example.toy.mvvm.github.entity

data class User(
  val login: String,
  val name: String?,
  val bio: String?,
  val isBookmark: Boolean? = false
)