package com.example.toy.mvvm.github.view

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.toy.mvvm.github.databinding.ItemUserBinding
import com.example.toy.mvvm.github.entity.User

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  private val binding = DataBindingUtil.bind<ItemUserBinding>(view)

  fun bind(vm: MainViewModel, user: User) {
    binding?.userName = if (user.name == null || user.name.isEmpty()) "null" else user.name
    binding?.description = if (user.bio == null || user.bio.isEmpty()) "null" else user.bio
    binding?.user = user
    binding?.viewModel = vm
  }
}