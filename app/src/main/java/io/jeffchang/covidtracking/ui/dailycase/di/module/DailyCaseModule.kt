package io.jeffchang.covidtracking.ui.dailycase.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.jeffchang.core.di.ViewModelKey
import io.jeffchang.covidtracking.ui.dailycase.viewmodel.DailyCaseViewModel

@Module
abstract class DailyCaseModule {

    @Binds
    @IntoMap
    @ViewModelKey(DailyCaseViewModel::class)
    abstract fun bindDailyCaseViewModel(viewModel: DailyCaseViewModel): ViewModel

}
