package com.template.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amoskorir.usecaseinteractors.usecases.UseCase

import com.amoskorir.usecaseinteractors.usecases.interfaces.UserUseCase
import com.template.domain.models.GithubUser


/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */

class UserViewModel(private val userUseCase: UserUseCase) : ViewModel() {
    private var stateMediatorLiveData = MediatorLiveData<State>()

    sealed class State {
        data class Users(val users: List<GithubUser>) : State()
        data class Profile(val user: GithubUser)
        object ShowLoading : State()
        object ShowContent : State()
        object ShowError : State()
    }

    init {
        stateMediatorLiveData = MediatorLiveData<State>()

        stateMediatorLiveData.addSource(userUseCase.getLiveData(), ::onFetchUsers)

    }

    fun getState(): LiveData<State> = stateMediatorLiveData

    fun fetchUsers() {
        stateMediatorLiveData.value = State.ShowLoading
        userUseCase.execute()
    }

    private fun onFetchUsers(result: UserUseCase.Result) {
        when (result) {
            is UserUseCase.Result.OnSuccess -> {
                stateMediatorLiveData.value = State.Users(result.memes)
                stateMediatorLiveData.value = State.ShowContent
            }
            is UserUseCase.Result.OnError -> stateMediatorLiveData.value = State.ShowError
        }
    }


}