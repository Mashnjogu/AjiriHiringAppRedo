package com.njogu.ajirihiringredone.models.service

import com.njogu.ajirihiringredone.models.User
import kotlinx.coroutines.flow.Flow

interface AccountService {
    val currentUserId: String
    val hasUser: Boolean

    val currentUser: Flow<User>

    suspend fun authenticate(email: String, password: String)
    suspend fun sendRecoveryEmail(email: String)
//    suspend fun createAnonymousAccount()
    suspend fun signUpAccount(email: String, password: String)
    suspend fun deleteAccount()
    suspend fun signOut()
}