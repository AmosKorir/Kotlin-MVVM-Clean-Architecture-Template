package com.template.data.api

import com.template.data.apiresponses.GithuserApiResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by Korir on 1/11/20.

 */

interface GithubApi {

  @GET("users")
  fun getUsers(): Single<List<GithuserApiResponse>>
}