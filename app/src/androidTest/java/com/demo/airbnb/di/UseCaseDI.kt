package com.demo.airbnb.di

import com.demo.airbnb.di.mocks.domain.usecases.places.GetPlacesCategoriesUCMocked
import com.demo.airbnb.di.mocks.domain.usecases.account.SignInUCMocked
import com.demo.airbnb.di.mocks.domain.usecases.places.GetPlacesByIdUCMocked
import com.demo.airbnb.domain.usecases.account.ISignInUC
import com.demo.airbnb.domain.usecases.places.IGetPlacesByIdUC
import com.demo.airbnb.domain.usecases.places.IGetPlacesCategoriesUC
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [UseCaseModule::class]
)
interface UseCaseModuleTest {
    @Singleton
    @Binds
    fun bindSignInUC(signInUC: SignInUCMocked): ISignInUC

    @Binds
    fun bindIGetPlacesByIdUC(getPlacesByIdUC: GetPlacesByIdUCMocked): IGetPlacesByIdUC

    @Binds
    fun bindIGetPlacesCategoriesUC(getPlacesCategoriesUC: GetPlacesCategoriesUCMocked): IGetPlacesCategoriesUC
}

