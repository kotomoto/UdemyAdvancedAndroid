package com.koto.advancedandroid.di

import android.app.Activity

import javax.inject.Inject
import javax.inject.Provider

import dagger.android.AndroidInjector

class ActivityInjector
@Inject
constructor(private val activityInjectors: Map<Class<out Activity>, Provider<AndroidInjector.Factory<out Activity>>>)
