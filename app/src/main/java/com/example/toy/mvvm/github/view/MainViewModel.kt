package com.example.toy.mvvm.github.view

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import androidx.lifecycle.ViewModel
import com.example.toy.mvvm.github.data.source.Repository
import com.example.toy.mvvm.github.entity.User
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainViewModel(private val repository: Repository) : ViewModel() {
  private val compositeDisposable = CompositeDisposable()

  val input = ObservableField<String>()
  val userList: ObservableList<User> = ObservableArrayList()

  override fun onCleared() {
    Log.i("MainViewModel", "onCleared")
    super.onCleared()
    compositeDisposable.clear()
  }

  fun searchUser() {
    if (input.get() == null || input.get()?.isEmpty() == true) {
      userList.clear()
      return
    }
    repository.searchUser(input.get()!!)
      .subscribe(this::addUser, this::onError)
      .addTo(compositeDisposable)
  }

  private fun addUser(user: User) {
    userList.add(user)
  }

  private fun onError(e: Throwable) {
    e.printStackTrace()
  }

}