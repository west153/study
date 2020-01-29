package com.example.toy.mvvm.github.data.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Single

interface BaseDao<T> {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(any: T): Completable

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(any: List<T>): Completable

  @Delete
  fun delete(any: T): Completable

  @Update(onConflict = OnConflictStrategy.ABORT)
  fun update(any: T): Single<Int>
}