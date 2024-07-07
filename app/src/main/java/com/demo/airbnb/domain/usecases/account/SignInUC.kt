package com.demo.airbnb.domain.usecases.account

import com.demo.airbnb.domain.entities.Session
import com.demo.airbnb.domain.entities.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SignInUC @Inject constructor() : ISignInUC {
    override
    suspend fun execute(email: String, password: String): Session {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000L)
        }
        val name = email.split("@").first()
        return Session(id = "1234", user = User(name = name, email = email))
    }
}
