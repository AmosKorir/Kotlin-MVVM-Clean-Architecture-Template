package com.template.data.repositories.apirepositories

import com.template.data.api.GithubApi
import com.template.data.mappers.UserMapper
import com.template.domain.models.GithubUser
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Korir on 1/11/20.

 */
class UserRepository(private val api: GithubApi) {
  fun getAllUsers(): Single<List<GithubUser>> {
    return api.getUsers()
      .flatMapPublisher { Flowable.fromIterable(it) }
      .map { UserMapper.transform(it) }
      .toList()
  }
}