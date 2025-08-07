package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.data.samples.PlaceCategorySample
import com.demo.airbnb.di.DispatcherIO
import com.demo.airbnb.domain.entities.PlaceCategory
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetPlacesCategoriesUC @Inject constructor(
    @DispatcherIO val coroutineContext: CoroutineContext
) : IGetPlacesCategoriesUC{
    override suspend fun execute(): List<PlaceCategory> {
        withContext(coroutineContext) {
            Thread.sleep(1000L)
        }
        return PlaceCategorySample
    }
}
