package com.demo.airbnb.di

import com.demo.airbnb.domain.usecases.account.ISignInUC
import com.demo.airbnb.domain.usecases.account.SignInUC
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Singleton
    @Binds
    fun bindISignInUC(signInUC: SignInUC): ISignInUC
}