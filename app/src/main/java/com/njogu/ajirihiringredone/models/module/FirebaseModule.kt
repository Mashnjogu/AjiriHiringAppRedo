package com.njogu.ajirihiringredone.models.module

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.njogu.ajirihiringredone.models.impl.AccountServiceImpl
import com.njogu.ajirihiringredone.models.impl.LogServiceImpl
import com.njogu.ajirihiringredone.models.service.AccountService
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

}

//@Module
//@InstallIn(SingletonComponent::class)
//abstract class FirebaseModule{
//    @Binds
//    fun auth():
//}


//@Module
//@InstallIn(SingletonComponent::class)
//abstract class FirebaseModule {
//
//    @Binds
//     fun auth(): FirebaseAuth
//
//    @Binds
//    abstract fun provideLogService(impl: LogServiceImpl): LogService
//}