package com.example.toy.mvvm.github.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.toy.mvvm.github.App
import com.example.toy.mvvm.github.R
import com.example.toy.mvvm.github.ViewModelFactory
import com.example.toy.mvvm.github.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  private lateinit var viewDataBinding: ActivityMainBinding

  @Inject
  lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (application as App).appComponent.inject(this)
    viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    viewDataBinding.lifecycleOwner = this
    viewDataBinding.viewModel = viewModel
  }


  private fun getVmFactory(): ViewModelFactory {
    val repository = (applicationContext as App).searchRepository
    return ViewModelFactory(repository)
  }

}
