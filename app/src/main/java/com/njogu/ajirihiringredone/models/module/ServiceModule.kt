package com.njogu.ajirihiringredone.models.module

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

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    abstract fun provideAccountService(impl: AccountServiceImpl): AccountService

    @Binds
    abstract fun provideLogService(impl: LogServiceImpl): LogService

    @Binds
    abstract fun provideImageService(impl: ImagesServicesImpl): ImagesServices
}