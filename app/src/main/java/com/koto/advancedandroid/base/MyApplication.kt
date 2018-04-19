package com.koto.advancedandroid.base

import android.app.Application
import com.koto.advancedandroid.di.ActivityInjector
import javax.inject.Inject

class MyApplication : Application() {

    lateinit var component: ApplicationComponent

    @Inject
    lateinit var activityInjector: ActivityInjector

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        component.inject(this)
    }
}