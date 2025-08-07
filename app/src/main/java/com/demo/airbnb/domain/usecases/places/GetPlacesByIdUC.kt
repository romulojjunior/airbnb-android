package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.data.samples.PlacesSamples
import com.demo.airbnb.di.DispatcherIO
import com.demo.airbnb.domain.entities.Place
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetPlacesByIdUC @Inject constructor(
    @DispatcherIO val coroutineContext: CoroutineContext
) : IGetPlacesByIdUC  {
     override suspend fun execute(id: Int): Place {
         withContext(coroutineContext) {
             Thread.sleep(1000L)
         }
        try {
            return PlacesSamples.first { it.id == id }
        } catch (e: NoSuchElementException) {
            throw Exception("Place not found.")
        }
    }
}
