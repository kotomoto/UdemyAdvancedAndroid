package com.koto.advancedandroid.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.koto.advancedandroid.di.Injector
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        const val INSTANCE_ID_KEY: String = "instance_id"
    }

    lateinit var instanceId: String
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        instanceId = if (savedInstanceState != null) {
            savedInstanceState.getString(INSTANCE_ID_KEY)
        } else {
            UUID.randomUUID().toString()
        }

        Injector.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(INSTANCE_ID_KEY, instanceId)
    }
}