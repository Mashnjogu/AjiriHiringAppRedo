package com.njogu.ajirihiringredone.authentication

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.njogu.ajirihiringredone.authentication.model.AuthResource
import com.njogu.ajirihiringredone.utils.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebasAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun Login(email: String, password: String): AuthResource<FirebaseUser> {
      return  try {
            val result = firebasAuth.signInWithEmailAndPassword(email, password).await()
            AuthResource.Success(result.user!!)
        }catch (e: Exception){
            e.printStackTrace()
            AuthResource.Failure(e)
        }
    }

    override suspend fun SignUp(
        name: String,
        email: String,
        password: String
    ): AuthResource<FirebaseUser> {
        return  try {
            val result = firebasAuth.createUserWithEmailAndPassword(email, password).await()
            result?.user?.updateProfile(
                UserProfileChangeRequest.Builder().setDisplayName(name).build()
            )?.await()
            AuthResource.Success(result.user!!)
        }catch (e: Exception){
            e.printStackTrace()
            AuthResource.Failure(e)
        }
    }


    override val currentUser: FirebaseUser?
        get() = firebasAuth.currentUser

    override fun logout() {
        firebasAuth.signOut()
    }
}