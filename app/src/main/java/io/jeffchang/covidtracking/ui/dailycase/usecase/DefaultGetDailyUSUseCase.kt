package io.jeffchang.covidtracking.ui.dailycase.usecase

import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase
import io.jeffchang.core.Result
import io.jeffchang.covidtracking.ui.dailycase.repository.DailyCaseRepository
import io.jeffchang.DailyCaselist.ui.DailyCase.usecase.GetDailyUSUseCase

class DefaultGetDailyUSUseCase(private val DailyCaseRepository: DailyCaseRepository) :
    GetDailyUSUseCase {

    override suspend fun invoke(params: Unit): Result<List<DailyCase>> {
        return DailyCaseRepository.getUSDailyCases()
    }

}