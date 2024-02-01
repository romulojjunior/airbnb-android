package com.demo.airbnb.di

import com.demo.airbnb.domain.entities.Session
import com.demo.airbnb.domain.entities.User
import com.demo.airbnb.domain.usecases.account.ISignInUC
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Inject
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
}

class SignInUCMocked @Inject constructor() : ISignInUC {
    override suspend fun execute(email: String, password: String): Session {
        return Session(id = "0001", user = User(name = "userTest", email = "userTest@test.com"))
    }
}