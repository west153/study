package com.example.toy.mvvm.github

import android.app.Application
import com.example.toy.mvvm.github.data.source.Repository
import com.example.toy.mvvm.github.di.DaggerAppComponent

class App : Application() {
  val appComponent by lazy { DaggerAppComponent.factory().create(this) }
  val searchRepository: Repository get() = RepositoryLocator.provideRepository(this)

  override fun onCreate() {
    super.onCreate()
  }
}