package com.koto.advancedandroid.di

import android.app.Activity
import android.content.Context

import com.koto.advancedandroid.base.BaseActivity
import com.koto.advancedandroid.base.MyApplication

import java.util.HashMap

import javax.inject.Inject
import javax.inject.Provider

import dagger.android.AndroidInjector

class ActivityInjector
@Inject
internal constructor(private val activityInjectors: Map<Class<out Activity>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Activity>>>) {

    private val cache = HashMap<String, AndroidInjector<out Activity>>()

    internal fun inject(activity: Activity) {
        if (activity !is BaseActivity) {
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }

        val instanceId = activity.instanceId
        if (cache.containsKey(instanceId)) {

            (cache[instanceId] as AndroidInjector<Activity>).inject(activity)
            return
        }

        val injectorFactory = activityInjectors[activity.javaClass]?.get() as AndroidInjector.Factory<Activity>
        val injector = injectorFactory.create(activity)
        cache[instanceId] = injector
        injector.inject(activity)
    }

    internal fun clear(activity: Activity) {
        if (activity !is BaseActivity) {
            throw IllegalArgumentException("Activity must extend BaseActivity")
        }

        cache.remove(activity.instanceId)
    }

    companion object {
        internal operator fun get(context: Context): ActivityInjector {
            return (context.applicationContext as MyApplication).activityInjector
        }
    }
}
