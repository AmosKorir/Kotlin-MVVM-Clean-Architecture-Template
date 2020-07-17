package com.template.kotlinmvvm

import android.app.Application
import com.amoskorir.usecaseinteractors.di.InteractorModule
import com.template.kotlinmvvm.di.activity.ActivityModule.Companion.activityModule
import com.template.viewmodels.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = ViewModelModule.datamodulepass
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    activityModule,
                    modules.apiModule,
                    modules.databaseModule,
                    modules.repositoryModule,
                    InteractorModule.integrator,
                    ViewModelModule.viewModelModule
                )
            )
        }
    }
}