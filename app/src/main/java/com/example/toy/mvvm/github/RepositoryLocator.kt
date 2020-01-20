package com.example.toy.mvvm.github

import com.example.toy.mvvm.github.data.githubBase
import com.example.toy.mvvm.github.data.source.DataSource
import com.example.toy.mvvm.github.data.source.Repository
import com.example.toy.mvvm.github.data.source.SearchDataSource
import com.example.toy.mvvm.github.data.source.SearchRepository
import com.example.toy.mvvm.github.data.source.remote.GithubApiManager

object RepositoryLocator {

  @Volatile
  var repository: Repository? = null

  fun provideRepository(): Repository {
    synchronized(this) {
      return repository ?: repository ?: createRepository()
    }
  }

  private fun createRepository(): Repository {
    val repository = SearchRepository(createDataSource())
    this.repository = repository
    return repository
  }

  private fun createDataSource(): DataSource {
    return SearchDataSource(GithubApiManager.getService(githubBase))
  }


}