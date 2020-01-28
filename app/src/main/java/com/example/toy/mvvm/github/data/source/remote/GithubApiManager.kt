package com.example.toy.mvvm.github.data.source.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GithubApiManager {

  private fun getInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
      level = HttpLoggingInterceptor.Level.BODY
    }
  }

  private fun getHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
      .connectTimeout(100, TimeUnit.SECONDS)
      .readTimeout(100, TimeUnit.SECONDS)
      .writeTimeout(100, TimeUnit.SECONDS)
      .addInterceptor(getInterceptor())
      .build()
  }

  private fun getGson(): Gson {
    return GsonBuilder()
      .setLenient()
      .create()
  }

  fun getService(baseUrl: String): GithubApiService {
    return Retrofit.Builder()
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .addConverterFactory(GsonConverterFactory.create(getGson()))
      .baseUrl(baseUrl)
      .client(getHttpClient())
      .build()
      .create(GithubApiService::class.java)
  }


}