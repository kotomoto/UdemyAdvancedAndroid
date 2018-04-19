package com.koto.advancedandroid.base

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ActivityBindingModule::class])
interface ApplicationComponent {

    fun inject(myApplication: MyApplication) {

    }
}