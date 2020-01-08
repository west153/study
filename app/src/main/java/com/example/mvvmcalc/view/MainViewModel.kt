package com.example.mvvmcalc.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcalc.Event
import com.example.mvvmcalc.R
import com.example.mvvmcalc.utils.Calculator

class MainViewModel(private val calculator: Calculator) : ViewModel() {

  val inputText = MutableLiveData<String>().default("")

  private val _showToast = MutableLiveData<Event<Int>>()
  val showToast: LiveData<Event<Int>> get() = _showToast

  fun clickNumber(number: Int) {
    inputText.value += number
  }

  fun clickOperator(operator: String) {
    val indexOf = (inputText.value?.length ?: 0) - 1
    if (indexOf >= 0) {
      val lastWord = inputText.value?.substring(indexOf) ?: return
      when (lastWord.isOperator()) {
        true -> inputText.value = inputText.value?.replaceRange(indexOf, indexOf + 1, operator)
        else -> inputText.value += operator
      }
    }
  }

  fun remove() {
    val starIndex = inputText.value?.length ?: 0
    if (starIndex > 0) {
      inputText.value = inputText.value?.removeRange(starIndex - 1, starIndex)
    }
  }

  fun clear() {
    inputText.value = ""
  }

  fun clickEquals() {
    val indexOf = (inputText.value?.length ?: 0) - 1
    if (indexOf >= 0) {
      val lastWord = inputText.value?.substring(indexOf) ?: return
      when (lastWord.isOperator()) {
        true -> _showToast.value = Event(R.string.toast_expression_error)
        else -> inputText.value = calculator.calculation(inputText.value ?: return)
      }
    }
  }

  private fun <T> MutableLiveData<T>.default(defaultValue: T) = apply { postValue(defaultValue) }

  private fun String.isOperator(): Boolean {
    return Regex("^[+\\-*/]$").matches(this)
  }
}