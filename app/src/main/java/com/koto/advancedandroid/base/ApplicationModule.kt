package com.koto.advancedandroid.base

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: Application) {

    @Provides
    fun provideApplicationContext(): Context {
        return application
    }
}