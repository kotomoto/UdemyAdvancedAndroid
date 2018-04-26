package com.koto.advancedandroid.home

import com.bluelinelabs.conductor.Controller
import com.koto.advancedandroid.R
import com.koto.advancedandroid.base.BaseActivity
import com.koto.advancedandroid.trending.TrendingReposController

class MainActivity : BaseActivity() {
    override fun layoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initialScreen(): Controller {
        return TrendingReposController()
    }
}
