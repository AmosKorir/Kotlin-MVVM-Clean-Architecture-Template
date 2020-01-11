package com.template.kotlinmvvm.di.activity

import com.template.kotlinmvvm.ui.activities.BaseActivity
import org.koin.dsl.module

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */
class ActivityModule{
  companion object{
    val activityModule= module {
      single { BaseActivity()}
    }
  }

}