package com.demo.airbnb.domain.usecases.account

import com.demo.airbnb.domain.entities.Session

interface ISignInUC {
    suspend fun execute(email: String, password: String): Session
}