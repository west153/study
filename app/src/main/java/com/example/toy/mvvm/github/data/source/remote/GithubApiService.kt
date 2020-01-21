package com.example.toy.mvvm.github.data.source.remote

import com.example.toy.mvvm.github.data.authorization
import com.example.toy.mvvm.github.data.searchUser
import com.example.toy.mvvm.github.data.token
import com.example.toy.mvvm.github.entity.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface GithubApiService {
  @GET(searchUser)
  fun searchUser(@Header(authorization) value: String = token, @Path("user") user: String): Flowable<User>
}