package com.example.toy.mvvm.github

import android.content.Context
import androidx.room.Room
import com.example.toy.mvvm.github.data.githubBase
import com.example.toy.mvvm.github.data.mapper.UserMapper
import com.example.toy.mvvm.github.data.source.DataSource
import com.example.toy.mvvm.github.data.source.Repository
import com.example.toy.mvvm.github.data.source.SearchDataSource
import com.example.toy.mvvm.github.data.source.SearchRepository
import com.example.toy.mvvm.github.data.source.local.GithubDataBase
import com.example.toy.mvvm.github.data.source.remote.GithubApiManager

object RepositoryLocator {

  private var database: GithubDataBase? = null
  @Volatile
  var repository: Repository? = null

  fun provideRepository(context: Context): Repository {
    synchronized(this) {
      return repository ?: repository ?: createRepository(context)
    }
  }

  private fun createRepository(context: Context): Repository {
    val repository = SearchRepository(createDataSource(context))
    this.repository = repository
    return repository
  }

  private fun createDataSource(context: Context): DataSource {
    val database = database ?: createDataBase(context)
    return SearchDataSource(
      GithubApiManager.getService(githubBase), database.userDao(), UserMapper()
    )
  }

  private fun createDataBase(context: Context): GithubDataBase {
    val db = Room.databaseBuilder(
      context.applicationContext,
      GithubDataBase::class.java, "memo.db"
    )
      .build()
    database = db
    return db
  }


}