package com.koto.advancedandroid.home

import com.bluelinelabs.conductor.Controller
import com.koto.advancedandroid.di.ControllerKey
import com.koto.advancedandroid.trending.TrendingReposComponent
import com.koto.advancedandroid.trending.TrendingReposController
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [TrendingReposComponent::class])
abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController::class)
    abstract fun bindTrendingReposInjector(builder: TrendingReposComponent.Builder): AndroidInjector.Factory<out Controller>
}