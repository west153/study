package com.example.toy.mvvm.github

import android.app.Application
import com.example.toy.mvvm.github.data.source.Repository

class App : Application() {
  val searchRepository: Repository get() = RepositoryLocator.provideRepository(this)
}