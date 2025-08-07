package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.data.samples.PlaceCategorySample
import com.demo.airbnb.domain.entities.PlaceCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetPlacesCategoriesUC @Inject constructor() : IGetPlacesCategoriesUC{
    override suspend fun execute(): List<PlaceCategory> {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000L)
        }
        return PlaceCategorySample
    }
}
