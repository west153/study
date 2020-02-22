package com.example.toy.mvvm.github.di

import android.content.Context
import com.example.toy.mvvm.github.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class])
interface AppComponent {

  fun inject(activity: MainActivity)

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): AppComponent
  }
}