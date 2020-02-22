package com.example.toy.mvvm.github.di

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
import com.example.toy.mvvm.github.data.source.remote.GithubApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

  @Provides
  fun provideRepository(dataSource: DataSource): Repository {
    return SearchRepository(dataSource)
  }

  @Provides
  fun provideDataSource(
    remote: GithubApiService,
    local: GithubDataBase,
    mapper: UserMapper
  ): DataSource {
    return SearchDataSource(remote, local.userDao(), mapper)
  }

  @Provides
  fun provideApiService(): GithubApiService {
    return GithubApiManager.getService(githubBase)
  }

  @Singleton
  @Provides
  fun provideDataBase(context: Context): GithubDataBase {
    return Room.databaseBuilder(
      context.applicationContext,
      GithubDataBase::class.java, "memo.db"
    )
      .build()
  }


}