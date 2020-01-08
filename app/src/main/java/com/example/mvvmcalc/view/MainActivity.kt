package com.example.mvvmcalc.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvmcalc.EventObserver
import com.example.mvvmcalc.R
import com.example.mvvmcalc.ViewModelFactory
import com.example.mvvmcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private val viewModelFactory by lazy { getVmFactory() }
  private lateinit var viewDataBinding: ActivityMainBinding
  private lateinit var viewModel: MainViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewDataBinding = DataBindingUtil.setContentView(
      this, R.layout.activity_main
    )
    viewModel = viewModels<MainViewModel> { viewModelFactory }.value

    viewDataBinding.lifecycleOwner = this
    viewDataBinding.viewModel = viewModel
    viewDataBinding.input.showSoftInputOnFocus = false

    viewModel.showToast.observe(this, EventObserver {
      Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    })
  }

  private fun getVmFactory() = ViewModelFactory()
}
