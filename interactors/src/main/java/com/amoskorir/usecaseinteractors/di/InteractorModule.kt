package com.amoskorir.usecaseinteractors.di

import com.amoskorir.usecaseinteractors.usecases.UserUseCaseImpl
import com.amoskorir.usecaseinteractors.usecases.interfaces.UserUseCase
import com.template.domain.di.DiConstants
import com.template.domain.repositories.UsersRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

class InteractorModule {
    companion object {
        val integrator = module {
            single { UserUseCaseImpl(get(named(DiConstants.API))) as UserUseCase }
        }
    }
}