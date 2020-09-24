package io.jeffchang.DailyCaselist.ui.DailyCase.repository

import com.nhaarman.mockitokotlin2.*
import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase
import io.jeffchang.covidtracking.ui.dailycase.data.service.CovidTrackingService
import io.jeffchang.core.Failure
import io.jeffchang.core.Success
import io.jeffchang.core.TestContextProvider
import io.jeffchang.covidtracking.ui.dailycase.repository.DefaultDailyCaseRepository
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import retrofit2.HttpException

class DailyCaseRepositoryTest {

    private val covidTrackingService: CovidTrackingService = mock()

    private val DailyCaseRepository = DefaultDailyCaseRepository(
        TestContextProvider(),
        covidTrackingService
    )

    @Test
    fun `getDailyCasees returns list of DailyCasees upon success`() {
        runBlocking {
            // Given

            // When
            whenever(covidTrackingService.getDailyCasees(any(), any())).doReturn(
                DailyCase(
                    total = 1,
                    region = Region(),
                    DailyCasees = listOf(
                        DailyCase()
                    )
                )
            )
            val result = DailyCaseRepository.getUSDailyCases("Los Angeles")

            // Then
            result shouldBeInstanceOf Success::class
            verify(covidTrackingService, times(1)).getDailyCasees(any(), any())
        }
    }

    @Test
    fun `getDailyCasees on http exception returns failure`() {
        runBlocking {
            // Given

            // When
            whenever(covidTrackingService.getDailyCasees(any(), any())).thenThrow(
                HttpException(
                    retrofit2.Response.error<DailyCase>(
                        404, ResponseBody.create(null, "")
                    )
                )
            )
            val result = DailyCaseRepository.getUSDailyCases("Los Angeles")

            // Then
            result shouldBeInstanceOf Failure::class
            verify(covidTrackingService, times(1)).getDailyCasees(any(), any())
        }
    }

}