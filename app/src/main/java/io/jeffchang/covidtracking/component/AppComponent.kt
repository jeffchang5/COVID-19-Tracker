package io.jeffchang.covidtracking.component

import dagger.Component
import io.jeffchang.core.CoreComponent
import io.jeffchang.core.scope.AppScope
import io.jeffchang.covidtracking.CovidTrackingApplication

@AppScope
@Component(dependencies = [CoreComponent::class])
interface AppComponent {

    fun inject(application: CovidTrackingApplication)

    @Component.Builder
    interface Builder {

        fun coreComponent(coreComponent: CoreComponent): Builder

        fun build(): AppComponent
    }
}
