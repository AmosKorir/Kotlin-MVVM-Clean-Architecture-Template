package com.template.viewmodels.di

import com.template.data.di.DataModule
import com.template.viewmodels.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */
class ViewModelModule {
  companion object {
    val datamodulepass = DataModule
    val viewModelModule = module {
      viewModel {
        UserViewModel(get())
      }
    }
  }

}