package com.demo.airbnb.domain.usecases.account

import com.demo.airbnb.di.DispatcherIO
import com.demo.airbnb.domain.entities.Session
import com.demo.airbnb.domain.entities.User
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SignInUC @Inject constructor(
    @DispatcherIO val coroutineContext: CoroutineContext
) : ISignInUC {
    override
    suspend fun execute(email: String, password: String): Session {
        withContext(coroutineContext) {
            Thread.sleep(1000L)
        }
        val name = email.split("@").first()
        return Session(id = "1234", user = User(name = name, email = email))
    }
}
