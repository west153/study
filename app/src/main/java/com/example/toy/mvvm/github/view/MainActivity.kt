package com.example.toy.mvvm.github.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.toy.mvvm.github.App
import com.example.toy.mvvm.github.R
import com.example.toy.mvvm.github.ViewModelFactory
import com.example.toy.mvvm.github.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var viewDataBinding: ActivityMainBinding
  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    viewModel = getViewModel()
    viewDataBinding.lifecycleOwner = this
    viewDataBinding.viewModel = viewModel
  }

  private fun getViewModel() = viewModels<MainViewModel> { getVmFactory() }.value

  private fun getVmFactory(): ViewModelFactory {
    val repository = (applicationContext as App).searchRepository
    return ViewModelFactory(repository)
  }
}
