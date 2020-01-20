package com.example.toy.mvvm.github.data.source

import com.example.toy.mvvm.github.data.source.remote.GithubApiService
import com.example.toy.mvvm.github.entity.User
import io.reactivex.Flowable

class SearchDataSource(private val apiService: GithubApiService) : DataSource {

  override fun searchUser(user: String): Flowable<User> {
    return apiService.searchUser()
  }
}