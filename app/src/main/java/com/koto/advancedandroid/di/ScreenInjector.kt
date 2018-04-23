package com.koto.advancedandroid.di

import android.app.Activity
import com.bluelinelabs.conductor.Controller
import com.koto.advancedandroid.base.BaseActivity
import com.koto.advancedandroid.base.BaseController
import dagger.android.AndroidInjector
import java.util.HashMap
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class ScreenInjector
@Inject
internal constructor(private val screenInjectors: Map<Class<out Controller>, @JvmSuppressWildcards Provider<AndroidInjector.Factory<out Controller>>>){

    private val cache = HashMap<String, AndroidInjector<out Controller>>()

    fun inject(controller: Controller) {
        if (controller !is BaseController) {
            throw IllegalArgumentException("Controller must extend BaseController")
        }

        val instanceId = controller.instanceId
        if (cache.containsKey(instanceId)) {
            (cache[instanceId] as AndroidInjector<Controller>).inject(controller)
            return
        }

        val injectorFactory: AndroidInjector.Factory<Controller> = screenInjectors[controller.javaClass]?.get() as AndroidInjector.Factory<Controller>
        val injector: AndroidInjector<Controller> = injectorFactory.create(controller)
        cache[instanceId] = injector
        injector.inject(controller)
    }

    fun clear(controller: Controller) {
        cache.remove(controller.instanceId)
    }

    companion object {
        fun get(activity: Activity?): ScreenInjector {
            if (activity !is BaseActivity) {
                throw IllegalArgumentException("Controller must be hosted by BaseActivity")
            }

            return activity.screenInjector
        }
    }
}