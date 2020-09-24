package io.jeffchang.DailyCaselist.ui.DailyCase.usecase

import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase
import io.jeffchang.core.Result


interface GetDailyUSUseCase {

    suspend operator fun invoke(params: Unit): Result<List<DailyCase>>

}