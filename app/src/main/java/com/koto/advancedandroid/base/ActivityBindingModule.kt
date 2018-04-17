package com.koto.advancedandroid.base

import android.app.Activity
import com.koto.advancedandroid.home.MainActivity
import com.koto.advancedandroid.home.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun provideMainActivityInjector(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>
}