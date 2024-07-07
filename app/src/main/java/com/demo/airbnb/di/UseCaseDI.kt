package com.demo.airbnb.di

import com.demo.airbnb.domain.usecases.account.ISignInUC
import com.demo.airbnb.domain.usecases.account.SignInUC
import com.demo.airbnb.domain.usecases.places.GetPlacesByIdUC
import com.demo.airbnb.domain.usecases.places.GetPlacesCategoriesUC
import com.demo.airbnb.domain.usecases.places.IGetPlacesByIdUC
import com.demo.airbnb.domain.usecases.places.IGetPlacesCategoriesUC
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Binds
    fun bindISignInUC(signInUC: SignInUC): ISignInUC

    @Binds
    fun bindIGetPlacesByIdUC(getPlacesByIdUC: GetPlacesByIdUC): IGetPlacesByIdUC

    @Binds
    fun bindIGetPlacesCategoriesUC(getPlacesCategoriesUC: GetPlacesCategoriesUC): IGetPlacesCategoriesUC
}