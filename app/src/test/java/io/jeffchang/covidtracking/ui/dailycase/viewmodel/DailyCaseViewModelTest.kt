package io.jeffchang.DailyCaselist.ui.DailyCase.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.jeffchang.core.*
import io.jeffchang.core.data.ViewState
import io.jeffchang.covidtracking.ui.dailycase.repository.DailyCaseRepository
import io.jeffchang.covidtracking.ui.dailycase.usecase.DefaultGetDailyUSUseCase
import io.jeffchang.covidtracking.ui.dailycase.viewmodel.DailyCaseViewModel
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class DailyCaseViewModelTest {

    private val coroutineContext = TestContextProvider()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Test
    fun `non-empty DailyCase list is success viewstate`() {
        runBlocking {
            val DailyCaseRepository: DailyCaseRepository = mock()
            whenever(DailyCaseRepository.getUSDailyCases(any())).doReturn(Success(listOf(DailyCase())))

            val useCase = DefaultGetDailyUSUseCase(DailyCaseRepository)

            val DailyCaseViewModel = DailyCaseViewModel(
                this@DailyCaseViewModelTest.coroutineContext, useCase
            )

            DailyCaseViewModel.viewState().value shouldBeInstanceOf ViewState.Success::class
        }
    }

    @Test
    fun `empty DailyCase list is empty viewstate`() {
        runBlocking {
            val DailyCaseRepository: DailyCaseRepository = mock()
            whenever(DailyCaseRepository.getUSDailyCases(any())).doReturn(Success(listOf()))

            val useCase = DefaultGetDailyUSUseCase(DailyCaseRepository)

            val DailyCaseViewModel = DailyCaseViewModel(
                this@DailyCaseViewModelTest.coroutineContext, useCase
            )

            DailyCaseViewModel.viewState().value shouldBeInstanceOf ViewState.Empty::class
        }
    }
    @Test
    fun `network error throws is error viewstate`() {
        runBlocking {
            val DailyCaseRepository: DailyCaseRepository = mock()
            whenever(DailyCaseRepository.getUSDailyCases(any())).doReturn(
                Failure(UnknownNetworkException)
            )

            val useCase = DefaultGetDailyUSUseCase(DailyCaseRepository)

            val DailyCaseViewModel = DailyCaseViewModel(
                this@DailyCaseViewModelTest.coroutineContext, useCase
            )

            DailyCaseViewModel.viewState().value shouldBeInstanceOf ViewState.Error::class
        }
    }
}