package com.example.shaunreddy.chatterchallenge.base

import android.app.Application
import com.example.shaunreddy.chatterchallenge.utils.dagger.NetComponent
import com.example.shaunreddy.chatterchallenge.utils.dagger.NetModule
import com.example.shaunreddy.chatterchallenge.utils.dagger.DaggerNetComponent


@Suppress("DEPRECATION")
class CharterApp : Application() {
    private var netComponent: NetComponent? = null

    override fun onCreate() {
        super.onCreate()

        netComponent = DaggerNetComponent.builder()
                .netModule(NetModule())
                .build()

    }

    fun getNetComponent(): NetComponent? {
        return netComponent
    }




}