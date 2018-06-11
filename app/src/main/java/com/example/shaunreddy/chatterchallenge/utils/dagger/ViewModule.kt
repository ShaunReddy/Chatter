package com.example.shaunreddy.chatterchallenge.utils.dagger

import com.example.shaunreddy.chatterchallenge.view.MainActivity
import com.example.shaunreddy.chatterchallenge.view.MainActivityContract
import dagger.Module
import dagger.Provides

@Module
class ViewModule {
    @Provides
    fun viewInstance() : MainActivity{
        return MainActivity();
    }
}