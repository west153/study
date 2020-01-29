package com.example.toy.mvvm.github.data.source

import com.example.toy.mvvm.github.data.dao.UserDao
import com.example.toy.mvvm.github.data.mapper.UserMapper
import com.example.toy.mvvm.github.data.source.remote.GithubApiService
import com.example.toy.mvvm.github.entity.User
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchDataSource(
  private val apiService: GithubApiService,
  private val userDao: UserDao,
  private val mapper: UserMapper
) : DataSource {

  override fun getBookmarkList(): List<User> {
    return userDao.findByAll().map(mapper::toVo)
  }

  override fun addBookmark(user: User): Completable {
    return userDao.insert(mapper.toEntity(user))
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  override fun removeBookmark(user: User): Completable {
    return userDao.delete(mapper.toEntity(user))
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }

  override fun searchUser(user: String): Flowable<User> {
    return apiService.searchUser(user = user)
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
  }
}