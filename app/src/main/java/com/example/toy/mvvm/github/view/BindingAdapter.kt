package com.example.toy.mvvm.github.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.toy.mvvm.github.entity.User

@BindingAdapter(value = ["item", "viewModel"])
fun RecyclerView.setAdapter(item: List<User>, vm: MainViewModel) {
  this.adapter?.run {
    (this as UserListAdapter).initList(item)
  } ?: run {
    UserListAdapter(vm).apply { this@setAdapter.adapter = this }
  }
}