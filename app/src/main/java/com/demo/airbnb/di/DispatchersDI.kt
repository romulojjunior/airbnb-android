package com.demo.airbnb.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DispatcherIO

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @DispatcherIO
    @Provides
    @Singleton
    fun provideIODispatcher(): CoroutineContext = Dispatchers.IO
}