package com.example.toy.mvvm.github.data.source

import com.example.toy.mvvm.github.entity.User
import io.reactivex.Completable
import io.reactivex.Flowable

interface DataSource {
  fun getBookmarkList(): List<User>
  fun addBookmark(user: User): Completable
  fun removeBookmark(user: User): Completable
  fun searchUser(user: String): Flowable<User>
}