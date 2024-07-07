package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.domain.entities.PlaceCategory

interface IGetPlacesCategoriesUC {
    suspend fun execute(): List<PlaceCategory>
}
