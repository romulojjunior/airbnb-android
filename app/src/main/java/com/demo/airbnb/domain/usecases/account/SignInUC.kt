package com.demo.airbnb.domain.usecases.account

import com.demo.airbnb.domain.entities.Session
import com.demo.airbnb.domain.entities.User
import javax.inject.Inject

class SignInUC @Inject constructor() {
    suspend fun execute(email: String, password: String): Session {
        Thread.sleep(1000L)
        val name = email.split("@").first()
        return Session(id = "1234", user = User(name = name, email = email))
    }
}
