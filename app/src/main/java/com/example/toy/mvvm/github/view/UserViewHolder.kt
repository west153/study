package com.example.toy.mvvm.github.view

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.toy.mvvm.github.databinding.ItemUserBinding

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  private val binding = DataBindingUtil.bind<ItemUserBinding>(view)

  fun bind(vm: MainViewModel, user: String) {
    binding?.userName = user
  }
}