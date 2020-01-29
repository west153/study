package com.example.toy.mvvm.github.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.toy.mvvm.github.data.entity.UserEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface UserDao : BaseDao<UserEntity> {

  @Query("SELECT * FROM User")
  fun findByAll(): List<UserEntity>

  @Query("SELECT * FROM User WHERE login = :id")
  fun findById(id: String): Flowable<UserEntity>

  @Query("DELETE FROM User WHERE login = :id")
  fun deleteById(id: String): Single<Int>

  @Query("DELETE FROM User")
  fun deleteAll(): Completable
}