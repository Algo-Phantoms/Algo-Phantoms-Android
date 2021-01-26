package com.algo.phantoms.algo_phantoms

import android.app.Application
import androidx.viewbinding.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree


class AlgoPhantoms: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

    }

}