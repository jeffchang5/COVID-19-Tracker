package io.jeffchang.covidtracking.ui.dailycase.di

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.di.BaseFragmentComponent
import io.jeffchang.core.di.module.ViewModelModule
import io.jeffchang.core.scope.FeatureScope
import io.jeffchang.covidtracking.ui.dailycase.di.module.DailyCaseDataModule
import io.jeffchang.covidtracking.ui.dailycase.view.DailyCaseFragment
import io.jeffchang.covidtracking.ui.dailycase.di.module.DailyCaseModule

/**
 * Component binding injections for DailyCase related classes
 */
@Component(
    modules = [ViewModelModule::class, DailyCaseModule::class, DailyCaseDataModule::class],
    dependencies = [CoreComponent::class]
)
@FeatureScope
interface DailyCaseComponent : BaseFragmentComponent<DailyCaseFragment> {

    @Component.Builder
    interface Builder {

        fun coreComponent(component: CoreComponent): Builder

        fun build(): DailyCaseComponent
    }
}
