package com.demo.airbnb.di.mocks.domain.usecases.account

import com.demo.airbnb.domain.entities.Session
import com.demo.airbnb.domain.entities.User
import com.demo.airbnb.domain.usecases.account.ISignInUC
import javax.inject.Inject

class SignInUCMocked @Inject constructor() : ISignInUC {
    override suspend fun execute(email: String, password: String): Session {
        return Session(id = "0001", user = User(name = "userTest", email = "userTest@test.com"))
    }
}
