package com.demo.airbnb.domain.entities

class Place(
    val id: Int,
    val name: String,
    val description: String,
    val address: String,
    val reviews: Long = 0,
    val starts: Double = 0.0,
    val price: Double,
    val coverUrl: String,
    val imagesUrl: List<String> = emptyList()
)