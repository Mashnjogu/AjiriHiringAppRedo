package com.njogu.ajirihiringredone.models.impl

import com.google.firebase.auth.FirebaseAuth
import com.njogu.ajirihiringredone.models.User
import com.njogu.ajirihiringredone.models.service.AccountService
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AccountServiceImpl @Inject constructor(
    private val auth: FirebaseAuth
): AccountService {

    override val currentUserId: String
        get() = auth.currentUser?.uid.orEmpty()
    override val hasUser: Boolean
        get() = auth.currentUser != null
    override val currentUser: Flow<User>
        get() = callbackFlow {
            val listener = FirebaseAuth.AuthStateListener { auth ->
                this.trySend(auth.currentUser?.let { User(id = it.uid) } ?: User())
            }
            auth.addAuthStateListener(listener)
            awaitClose{auth.removeAuthStateListener(listener)}
        }

    override suspend fun authenticate(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun sendRecoveryEmail(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun signUpAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun deleteAccount() {
        TODO("Not yet implemented")
    }

    override suspend fun signOut() {
        TODO("Not yet implemented")
    }
}