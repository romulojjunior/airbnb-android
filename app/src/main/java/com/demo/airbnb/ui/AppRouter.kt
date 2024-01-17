package com.demo.airbnb.ui


object AppRouter {
    const val loginPath = "/login"
    const val homePath = "/home"
    const val placeDetailsPath = "/places/{id}"

    fun loginPath() = loginPath

    fun homePath() = homePath
    fun placeDetailsPath(placeId: Int) = "/places/$placeId"
}