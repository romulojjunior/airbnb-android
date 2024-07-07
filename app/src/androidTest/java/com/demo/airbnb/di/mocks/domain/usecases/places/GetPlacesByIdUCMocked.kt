package com.demo.airbnb.di.mocks.domain.usecases.places

import com.demo.airbnb.data.samples.PlacesSamples
import com.demo.airbnb.domain.entities.Place
import com.demo.airbnb.domain.usecases.places.IGetPlacesByIdUC
import javax.inject.Inject

class GetPlacesByIdUCMocked @Inject constructor() : IGetPlacesByIdUC {
    override suspend fun execute(id: Int): Place {
        try {
            return PlacesSamples.first { it.id == id }
        } catch (e: NoSuchElementException) {
            throw Exception("Place not found.")
        }
    }
}

