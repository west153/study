package com.example.toy.mvvm.github.view

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import com.example.toy.mvvm.github.data.source.Repository
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val repository: Repository) : BaseObservable() {
  private val compositeDisposable = CompositeDisposable()

  var input = ObservableField<String>()

  fun searchUser() {
    Log.d("input", "${input.get()}")
  }
}