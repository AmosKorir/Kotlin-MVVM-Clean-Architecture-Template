package com.template.data.di

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */
class DataModule {
  companion object {
    val repositoryModule = RepositoryModule.repositoryModule
    val databaseModule = DatabaseModule.databaseModule
    val apiModule = ApiModule.apiModule
  }
}