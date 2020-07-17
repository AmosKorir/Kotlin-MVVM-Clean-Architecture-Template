package com.amoskorir.usecaseinteractors.usecases.interfaces

import com.amoskorir.usecaseinteractors.usecases.UseCase
import com.template.domain.models.GithubUser
import com.amoskorir.usecaseinteractors.usecases.interfaces.UserUseCase.Result

interface UserUseCase : UseCase<Result> {

    sealed class Result {
        data class OnSuccess(val memes: List<GithubUser>) : Result()
        object OnError : Result()
    }

    fun execute()
}