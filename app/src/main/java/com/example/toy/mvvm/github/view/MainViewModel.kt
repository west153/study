package com.example.toy.mvvm.github.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toy.mvvm.github.data.source.Repository
import com.example.toy.mvvm.github.entity.User
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo

class MainViewModel(private val repository: Repository) : ViewModel() {
  private val compositeDisposable = CompositeDisposable()

  val input = MutableLiveData<String>()

  private val _userList = MutableLiveData<List<User>>()
  val userList: LiveData<List<User>> get() = _userList

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }

  fun searchUser() {
    if (input.value == null || input.value?.isEmpty() == true) {
      _userList.value = arrayListOf()
      return
    }
    repository.searchUser(input.value!!)
      .subscribe(this::addUser, this::onError)
      .addTo(compositeDisposable)
  }

  private fun addUser(user: User) {
    _userList.value = _userList.value?.toMutableList()?.apply { this.add(user) }
  }

  private fun onError(e: Throwable) {
    e.printStackTrace()
  }

}