package com.template.domain.repositories

import com.template.domain.models.GithubUser
import io.reactivex.Single

/**
 * Created by Korir on 1/12/20.
 * amoskrr@gmail.com
 */
interface UsersRepository {

  fun getUsers(): Single<List<GithubUser>>
}