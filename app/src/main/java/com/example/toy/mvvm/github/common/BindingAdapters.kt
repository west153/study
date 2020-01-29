package com.example.toy.mvvm.github.common

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.toy.mvvm.github.entity.User
import com.example.toy.mvvm.github.view.MainViewModel
import com.example.toy.mvvm.github.view.UserListAdapter

@BindingAdapter(value = ["item", "viewModel"])
fun RecyclerView.setAdapter(item: List<User>?, vm: MainViewModel) {
  this.adapter?.run {
    (this as UserListAdapter).initList(item ?: arrayListOf())
  } ?: run {
    UserListAdapter(vm).apply { this@setAdapter.adapter = this }
  }
}

@BindingAdapter(value = ["selected"])
fun View.isSelected(selected: Boolean) {
  this.isSelected = selected
}