package com.example.toy.mvvm.github.data.mapper

interface Mapper<E, V> {
  fun toVo(entity: E): V
  fun toEntity(vo: V): E
}