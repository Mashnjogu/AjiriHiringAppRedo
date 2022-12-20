package com.njogu.ajirihiringredone.authentication

import com.google.firebase.auth.FirebaseUser
import com.njogu.ajirihiringredone.authentication.model.AuthResource

interface AuthRepository {
    suspend fun Login(email: String, password: String): AuthResource<FirebaseUser>
    suspend fun SignUp(name: String,email:String, password: String): AuthResource<FirebaseUser>
    val currentUser: FirebaseUser?
    fun logout()
}