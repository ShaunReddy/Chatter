package com.example.shaunreddy.chatterchallenge.utils.dagger

import com.example.shaunreddy.chatterchallenge.view.MainActivityContract
import com.example.shaunreddy.chatterchallenge.view.MainActivityPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providerPresenter() : MainActivityPresenter{
        return MainActivityPresenter();
    }
}