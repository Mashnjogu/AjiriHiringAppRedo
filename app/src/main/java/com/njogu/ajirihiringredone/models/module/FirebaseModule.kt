package com.njogu.ajirihiringredone.models.module

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.njogu.ajirihiringredone.models.impl.AccountServiceImpl
import com.njogu.ajirihiringredone.models.impl.ImagesServicesImpl
import com.njogu.ajirihiringredone.models.impl.LogServiceImpl
import com.njogu.ajirihiringredone.models.service.AccountService
import com.njogu.ajirihiringredone.models.service.ImagesServices
import com.njogu.ajirihiringredone.models.service.LogService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides fun auth(): FirebaseAuth = Firebase.auth

    @Provides
    fun provideFirebaseStorage(): FirebaseStorage = Firebase.storage

    @Provides
    fun provideFirebaseFirestore(): FirebaseFirestore = Firebase.firestore


}

