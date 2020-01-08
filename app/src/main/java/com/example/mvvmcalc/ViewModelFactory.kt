package com.example.mvvmcalc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcalc.utils.Calculator
import com.example.mvvmcalc.view.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory() :
  ViewModelProvider.NewInstanceFactory() {

  override fun <T : ViewModel?> create(modelClass: Class<T>): T =
    with(modelClass) {
      when {
        isAssignableFrom(MainViewModel::class.java) -> MainViewModel(Calculator())
        else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
      }
    } as T
}