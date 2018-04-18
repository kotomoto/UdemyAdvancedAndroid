package com.koto.advancedandroid.di

import android.app.Activity

class Injector {
    private constructor()

    companion object {
        fun inject(activity: Activity) {}
    }
}