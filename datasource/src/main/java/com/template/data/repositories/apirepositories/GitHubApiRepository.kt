package com.template.data.repositories.apirepositories

import com.template.data.api.GithubApi
import com.template.data.mappers.UserMapper
import com.template.domain.models.GithubUser
import com.template.domain.repositories.UsersRepository
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Korir on 1/11/20.

 */
class UserAPiRepository(private val api: GithubApi) : UsersRepository {
  override fun getUsers(): Single<List<GithubUser>> {
    return api.getUsers()
      .flatMapPublisher { Flowable.fromIterable(it) }
      .map { UserMapper.transform(it) }
      .toList()
  }
}