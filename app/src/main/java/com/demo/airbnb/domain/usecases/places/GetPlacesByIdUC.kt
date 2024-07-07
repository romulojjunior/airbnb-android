package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.data.samples.PlacesSamples
import com.demo.airbnb.domain.entities.Place
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPlacesByIdUC @Inject constructor() : IGetPlacesByIdUC  {
     override suspend fun execute(id: Int): Place {
         withContext(Dispatchers.IO) {
             Thread.sleep(1000L)
         }
        try {
            return PlacesSamples.first { it.id == id }
        } catch (e: NoSuchElementException) {
            throw Exception("Place not found.")
        }
    }
}
