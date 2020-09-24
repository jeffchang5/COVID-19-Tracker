package io.jeffchang.covidtracking.ui.dailycase

import io.jeffchang.covidtracking.coreComponent
import io.jeffchang.covidtracking.ui.dailycase.di.DaggerDailyCaseComponent

import io.jeffchang.covidtracking.ui.dailycase.view.DailyCaseFragment

// Injector for DailyCase fragment.
fun DailyCaseFragment.inject() {
    DaggerDailyCaseComponent.builder()
        .coreComponent(coreComponent())
        .build()
        .inject(this)
}

