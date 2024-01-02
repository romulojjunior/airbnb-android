package com.demo.airbnb.domain.entities

data class PlaceCategory(
    val id: Int,
    val name: String,
    val priority: Int = 0,
    val places: List<Place> = emptyList()
)