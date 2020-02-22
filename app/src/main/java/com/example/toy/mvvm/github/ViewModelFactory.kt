package com.example.toy.mvvm.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.toy.mvvm.github.data.source.Repository
import com.example.toy.mvvm.github.view.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) :
  ViewModelProvider.NewInstanceFactory() {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T =
    with(modelClass) {
      when {
        isAssignableFrom(MainViewModel::class.java) -> MainViewModel(repository)
        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
      }
    } as T
}