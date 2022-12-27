package com.njogu.ajirihiringredone.authentication

import com.google.firebase.auth.FirebaseUser
import com.njogu.ajirihiringredone.authentication.model.AuthResource

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthResource<FirebaseUser>
    suspend fun signUp(name: String,email:String, password: String): AuthResource<FirebaseUser>
    val currentUser: FirebaseUser?
    fun logout()
}