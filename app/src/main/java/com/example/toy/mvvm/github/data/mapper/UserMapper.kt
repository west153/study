package com.example.toy.mvvm.github.data.mapper

import com.example.toy.mvvm.github.data.entity.UserEntity
import com.example.toy.mvvm.github.entity.User

class UserMapper : Mapper<UserEntity, User> {

  override fun toVo(entity: UserEntity): User {
    return User(entity.login, entity.name, entity.bio, entity.isBookmark)
  }

  override fun toEntity(vo: User): UserEntity {
    return UserEntity(vo.login, vo.name, vo.bio, vo.isBookmark)
  }
}