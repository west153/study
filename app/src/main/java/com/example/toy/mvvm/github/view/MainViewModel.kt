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

  private val _userList = MutableLiveData<List<User>?>().apply { initList() }
  val userList: LiveData<List<User>?> get() = _userList

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }

  private fun initList() {
    Thread {
      _userList.postValue(repository.getBookmarkList())
    }.start()
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

  fun bookmark(user: User) {
    val disposable = if (user.isBookmark == true) {
      repository.removeBookmark(user)
    } else {
      repository.addBookmark(user.copy(isBookmark = true))
    }

    disposable
      .subscribe({ replaceList(user) }, this::onError)
      .addTo(compositeDisposable)
  }

  private fun replaceList(user: User) {
    _userList.value = _userList.value?.toMutableList()?.apply {
      val index = this.indexOfFirst { it.login == user.login }
      this[index] = user.copy(isBookmark = user.isBookmark != true)
    }
  }

  private fun addUser(user: User) {
    _userList.value = if (_userList.value == null) {
      arrayListOf(user)
    } else {
      _userList.value?.toMutableList()?.apply { this.add(user) }
    }
  }

  private fun onError(e: Throwable) {
    e.printStackTrace()
  }
}