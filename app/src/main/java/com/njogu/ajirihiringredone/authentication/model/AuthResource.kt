package com.njogu.ajirihiringredone.authentication.model

sealed class AuthResource<out R>{
    data class Success<out R>(val Result: R) : AuthResource<R>()
    data class Failure(val exception: Exception): AuthResource<Nothing>()
    object Loading: AuthResource<Nothing>()
}
