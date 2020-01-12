package com.template.data.di

import com.template.data.repositories.apirepositories.UserAPiRepository
import com.template.data.repositories.roomrepositories.UsersDbRepository
import com.template.domain.di.DiConstants
import com.template.domain.repositories.UsersRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */

class RepositoryModule {
  companion object {
    val repositoryModule = module {
      single(named(DiConstants.API)) { UserAPiRepository(get()) as UsersRepository }
      single(named(DiConstants.DB)) { UsersDbRepository() as UsersRepository }
    }
  }
}