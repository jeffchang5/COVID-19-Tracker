package io.jeffchang.covidtracking.ui.dailycase.repository

import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.Result
import io.jeffchang.core.safeApiCall
import io.jeffchang.covidtracking.ui.dailycase.data.service.CovidTrackingService
import kotlinx.coroutines.withContext

class DefaultDailyCaseRepository(
    private val provider: ContextProvider,
    private val covidTrackingService: CovidTrackingService
) : DailyCaseRepository {

    override suspend fun getUSDailyCases(): Result<List<DailyCase>> {
        return withContext(provider.io) {
            safeApiCall {
                covidTrackingService.getDailyCasees()
            }
        }
    }
}