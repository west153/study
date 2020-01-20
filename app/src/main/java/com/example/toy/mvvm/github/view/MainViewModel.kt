package com.example.toy.mvvm.github.view

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import androidx.lifecycle.ViewModel
import com.example.toy.mvvm.github.data.source.Repository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: Repository) : ViewModel() {
  private val compositeDisposable = CompositeDisposable()

  val input = ObservableField<String>()
  private val userList: ObservableList<String> = ObservableArrayList()

  fun searchUser() {
    userList.clear()
    userList.add("User: ${input.get()} 0")
    userList.add("User: ${input.get()} 1")
    userList.add("User: ${input.get()} 2")
    userList.add("User: ${input.get()} 3")
  }
}