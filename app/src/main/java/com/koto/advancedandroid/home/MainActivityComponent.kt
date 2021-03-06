package com.koto.advancedandroid.home

import com.koto.advancedandroid.di.ActivityScope
import com.koto.advancedandroid.ui.NavigationModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [MainScreenBindingModule::class, NavigationModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}