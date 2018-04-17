package com.koto.advancedandroid.home

import com.koto.advancedandroid.di.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}