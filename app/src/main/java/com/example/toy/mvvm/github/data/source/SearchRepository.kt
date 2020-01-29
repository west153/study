package com.example.toy.mvvm.github.data.source

import com.example.toy.mvvm.github.entity.User
import io.reactivex.Completable
import io.reactivex.Flowable

class SearchRepository(private val dataSource: DataSource) : Repository {
  override fun searchUser(user: String): Flowable<User> {
    return dataSource.searchUser(user)
  }

  override fun getBookmarkList(): List<User> {
    return dataSource.getBookmarkList()
  }

  override fun addBookmark(user: User): Completable {
    return dataSource.addBookmark(user)
  }

  override fun removeBookmark(user: User): Completable {
    return dataSource.removeBookmark(user)
  }
}