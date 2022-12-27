package com.njogu.ajirihiringredone.authentication.di

import com.google.firebase.auth.FirebaseAuth
import com.njogu.ajirihiringredone.authentication.AuthRepository
import com.njogu.ajirihiringredone.authentication.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun providesFirebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    fun providesAuthRepository(authImpl: AuthRepositoryImpl): AuthRepository{
        return authImpl
    }
}