package io.jeffchang.covidtracking.ui.dailycase.di.module

import dagger.Module
import dagger.Provides
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.covidtracking.ui.dailycase.data.service.CovidTrackingService
import io.jeffchang.covidtracking.ui.dailycase.repository.DefaultDailyCaseRepository
import io.jeffchang.covidtracking.ui.dailycase.repository.DailyCaseRepository
import io.jeffchang.covidtracking.ui.dailycase.usecase.DefaultGetDailyUSUseCase
import io.jeffchang.DailyCaselist.ui.DailyCase.usecase.GetDailyUSUseCase
import retrofit2.Retrofit

@Module
class DailyCaseDataModule {
    @Provides
    @FeatureScope
    fun provideDailyCaseService(retrofit: Retrofit): CovidTrackingService =
        retrofit.create(CovidTrackingService::class.java)

    @Provides
    @FeatureScope
    fun provideDailyCaseRepository(
        contextProvider: ContextProvider,
        CovidTrackingService: CovidTrackingService
    ): DailyCaseRepository =
        DefaultDailyCaseRepository(contextProvider, CovidTrackingService)

    @Provides
    @FeatureScope
    fun provideGetDailyCaseUseCase(
        DailyCaseRepository: DailyCaseRepository
    ): GetDailyUSUseCase = DefaultGetDailyUSUseCase(DailyCaseRepository)

}
