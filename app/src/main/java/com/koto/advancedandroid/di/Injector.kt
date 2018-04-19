package com.koto.advancedandroid.di

import android.app.Activity

class Injector {
    companion object {
        fun inject(activity: Activity) {
            ActivityInjector.get(activity).inject(activity)
        }

        fun clearComponent(activity: Activity) {
            ActivityInjector.get(activity).clear(activity)
        }
    }
}