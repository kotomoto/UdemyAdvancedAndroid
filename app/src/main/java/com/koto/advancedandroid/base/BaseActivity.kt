package com.koto.advancedandroid.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.koto.advancedandroid.R
import com.koto.advancedandroid.di.Injector
import com.koto.advancedandroid.di.ScreenInjector
import java.util.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        const val INSTANCE_ID_KEY: String = "instance_id"
    }

    lateinit var instanceId: String
        private set

    lateinit var router: Router

    @Inject
    lateinit var screenInjector: ScreenInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = if (savedInstanceState != null) {
            savedInstanceState.getString(INSTANCE_ID_KEY)
        } else {
            UUID.randomUUID().toString()
        }

        Injector.inject(this)

        setContentView(layoutRes())
        val screenContainer: ViewGroup = findViewById(R.id.screen_container)
                ?: throw NullPointerException("Activity must have a view with id: screen_container")

        router = Conductor.attachRouter(this, screenContainer, savedInstanceState)
        monitorBackStack()

        super.onCreate(savedInstanceState)
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(INSTANCE_ID_KEY, instanceId)
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing) {
            Injector.clearComponent(this)
        }
    }

    private fun monitorBackStack() {
        router.addChangeListener(object : ControllerChangeHandler.ControllerChangeListener {
            override fun onChangeStarted(
                    to: Controller?,
                    from: Controller?,
                    isPush: Boolean,
                    container: ViewGroup,
                    handler: ControllerChangeHandler) {
            }

            override fun onChangeCompleted(
                    to: Controller?,
                    from: Controller?,
                    isPush: Boolean,
                    container: ViewGroup,
                    handler: ControllerChangeHandler) {
                if (!isPush && from != null) {
                    Injector.clearComponent(from)
                }
            }
        })
    }
}