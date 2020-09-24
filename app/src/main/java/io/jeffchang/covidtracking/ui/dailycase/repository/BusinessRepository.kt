package io.jeffchang.covidtracking.ui.dailycase.repository

import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase
import io.jeffchang.core.Result


interface DailyCaseRepository {

    suspend fun getUSDailyCases(): Result<List<DailyCase>>

}
