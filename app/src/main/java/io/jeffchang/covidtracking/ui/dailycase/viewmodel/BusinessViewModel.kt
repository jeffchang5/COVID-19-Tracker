package io.jeffchang.covidtracking.ui.dailycase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase
import io.jeffchang.core.ContextProvider
import io.jeffchang.core.data.ViewState
import io.jeffchang.core.onFailure
import io.jeffchang.core.onSuccess
import io.jeffchang.DailyCaselist.ui.DailyCase.usecase.GetDailyUSUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class DailyCaseViewModel @Inject constructor(
    private val contextProvider: ContextProvider,
    private val getDailyUSUseCase: GetDailyUSUseCase
) : ViewModel() {

    private val viewState = MutableLiveData<ViewState<List<DailyCase>>>()

    init {
        getDailyCasees()
    }

    fun viewState(): LiveData<ViewState<List<DailyCase>>> = viewState

    fun getDailyCasees() {
        launch {
            getDailyUSUseCase(Unit)
                .onSuccess {
                    if (it.isEmpty()) {
                        viewState.postValue(ViewState.Empty())
                        return@onSuccess
                    }
                    Timber.d("Received US daily cases")
                    viewState.postValue(ViewState.Success(it))
                }
                .onFailure {
                    viewState.postValue(ViewState.Error(it))
                }
        }
    }

    private fun launch(
        coroutineContext: CoroutineContext = contextProvider.main,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch(coroutineContext) { block() }
    }

}
