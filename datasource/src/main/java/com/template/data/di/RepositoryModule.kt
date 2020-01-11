package com.template.data.di

import com.template.data.repositories.apirepositories.UserRepository
import org.koin.dsl.module

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */

class RepositoryModule{
companion object{
  val repositoryModule= module {
    single {
      UserRepository(get())
    }
  }
}
}