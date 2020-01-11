package com.template.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.template.data.repositories.apirepositories.UserRepository
import com.template.domain.models.GithubUser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Korir on 1/11/20.
 * amoskrr@gmail.com
 */

class UserViewModel(userRepository: UserRepository) : ViewModel() {
  var userapiRepository = userRepository
  lateinit var compositeDisposable: CompositeDisposable
  var userLiveData = MutableLiveData<List<GithubUser>>()
  var errorLiveData = MutableLiveData<Throwable>()

  fun getUsers() {
    compositeDisposable = CompositeDisposable()
    val disposable = userapiRepository.getAllUsers()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        userLiveData.postValue(it)
      }, {
        handleError(it)
      })
    compositeDisposable.add(disposable)
  }

  fun handleError(throwable: Throwable) {
    errorLiveData.postValue(throwable)
  }


}