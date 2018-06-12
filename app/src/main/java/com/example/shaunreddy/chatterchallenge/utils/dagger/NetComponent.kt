package com.example.shaunreddy.chatterchallenge.utils.dagger

import com.example.shaunreddy.chatterchallenge.view.banklist.MainActivity
import dagger.Component
import javax.inject.Singleton

// Make the NetComponent singleton and add all modules in @Component
@Singleton
@Component(modules = [  NetModule::class ]) //AppModule::class,
interface NetComponent {
    /**
     * @param activity: MainActivity
     * inject modules in mainActivity
     */
    fun inject(activity: MainActivity)
}