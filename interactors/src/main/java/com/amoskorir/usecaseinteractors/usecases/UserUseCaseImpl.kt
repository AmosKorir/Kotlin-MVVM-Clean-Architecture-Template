package com.amoskorir.usecaseinteractors.usecases

import com.amoskorir.usecaseinteractors.usecases.interfaces.UserUseCase
import com.amoskorir.usecaseinteractors.usecases.interfaces.UserUseCase.Result
import com.template.domain.models.GithubUser
import com.template.domain.repositories.UsersRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserUseCaseImpl(
    private val usersRepository: UsersRepository
) : BaseUseCase<Result>(), UserUseCase {

    override fun execute() {
        val disposable = usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> success(result) }, { error -> error(error) }
            )
        compositeDisposable.add(disposable)
    }

    private fun success(memes: List<GithubUser>) {
        liveData.value = Result.OnSuccess(memes)
    }

    private fun error(throwable: Throwable) {
        liveData.value = Result.OnError
    }
}