package com.template.data.repositories.roomrepositories

import com.template.domain.models.GithubUser
import com.template.domain.repositories.UsersRepository
import io.reactivex.Single

/**
 * Created by Korir on 1/12/20.
 * amoskrr@gmail.com
 */
class UsersDbRepository : UsersRepository{
  override fun getUsers(): Single<List<GithubUser>> {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

}