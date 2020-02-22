package com.example.toy.mvvm.github.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toy.mvvm.github.R
import com.example.toy.mvvm.github.entity.User

class UserListAdapter(private val viewModel: MainViewModel) :
  RecyclerView.Adapter<UserViewHolder>() {

  private val userList = arrayListOf<User>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
    LayoutInflater.from(parent.context)
      .inflate(R.layout.item_user, parent, false)
      .let { UserViewHolder(it) }


  override fun getItemCount(): Int = userList.size

  override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
    holder.bind(viewModel, userList[position])
  }

  fun initList(item: List<User>) {
    userList.clear()
    userList.addAll(item)
    notifyDataSetChanged()
  }
}