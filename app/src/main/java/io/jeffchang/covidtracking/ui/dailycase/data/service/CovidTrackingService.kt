package io.jeffchang.covidtracking.ui.dailycase.data.service

import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase
import retrofit2.http.GET

interface CovidTrackingService {

    @GET("/v1/us/daily.json")
    suspend fun getDailyCasees(): List<DailyCase>

}
