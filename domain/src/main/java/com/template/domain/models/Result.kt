package com.template.domain.models

sealed class Result {
    data class OnSuccess(val memes: List<GithubUser>) : Result()
    object OnError : Result()
}