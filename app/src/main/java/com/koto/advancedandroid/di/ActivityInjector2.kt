package com.koto.advancedandroid.di

import android.app.Activity
import android.content.Context
import com.koto.advancedandroid.base.BaseActivity
import com.koto.advancedandroid.base.MyApplication
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

//class ActivityInjector
//@Inject
//constructor(private val activityInjectors: Map<Class<out Activity>, Provider<AndroidInjector.Factory<Activity>>>,
//            private val cache: MutableMap<String, AndroidInjector<Activity>> = HashMap()) {
//
//    fun inject(activity: Activity) {
//        if (activity !is BaseActivity) {
//            throw IllegalArgumentException("Activity must extend BaseActivity")
//        }
//
//        val instanceId = activity.instanceId
//        if (cache.containsKey(instanceId)) {
//            cache[instanceId]?.inject(activity)
//            return
//        }
//
//        val injectorFactory = activityInjectors[activity.javaClass]?.get() as AndroidInjector.Factory<Activity>
//        val injector: AndroidInjector<Activity> = injectorFactory.create(activity)
//        cache[instanceId] = injector
//        injector.inject(activity)
//    }
//
//    fun clear(activity: Activity) {
//        if (activity !is BaseActivity) {
//            throw IllegalArgumentException("Activity must extend BaseActivity")
//        }
//
//        cache.remove(activity.instanceId)
//    }
//
//    companion object {
//        fun get(context: Context): ActivityInjector {
//            return (context.applicationContext as MyApplication).activityInjector
//        }
//    }
//}
