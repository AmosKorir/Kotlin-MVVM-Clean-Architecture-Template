package com.template.data.mappers

import com.template.data.apiresponses.GithuserApiResponse
import com.template.domain.models.GithubUser

/**
 * Created by Korir on 1/12/20.
 * amoskrr@gmail.com
 */
class UserMapper{
  companion object{
    fun transform(githuserApiResponse: GithuserApiResponse):GithubUser{
      return GithubUser(
        githuserApiResponse.id,
        githuserApiResponse.login,
        githuserApiResponse.avatar_url
      )
    }
  }
}