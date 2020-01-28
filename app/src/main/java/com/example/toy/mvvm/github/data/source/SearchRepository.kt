package com.example.toy.mvvm.github.data.source

import com.example.toy.mvvm.github.entity.User
import io.reactivex.Flowable

class SearchRepository(private val dataSource: DataSource) : Repository {
  override fun searchUser(user: String): Flowable<User> {
    return dataSource.searchUser(user)
  }
}