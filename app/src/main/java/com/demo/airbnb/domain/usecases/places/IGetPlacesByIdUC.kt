package com.demo.airbnb.domain.usecases.places

import com.demo.airbnb.domain.entities.Place

interface IGetPlacesByIdUC {
    suspend fun execute(id: Int): Place
}
