package com.amoskorir.usecaseinteractors.usecases

import androidx.lifecycle.LiveData

interface UseCase<T> {

    fun getLiveData(): LiveData<T>

    fun cleanUp()
}