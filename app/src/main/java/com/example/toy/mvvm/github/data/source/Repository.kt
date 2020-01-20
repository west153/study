package com.example.toy.mvvm.github.data.source

import com.example.toy.mvvm.github.entity.User
import io.reactivex.Flowable

interface Repository {
  fun searchUser(user: String): Flowable<User>
}