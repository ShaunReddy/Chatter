package com.example.shaunreddy.chatterchallenge.utils.dagger

import com.example.shaunreddy.chatterchallenge.datasource.network.DataManager
import com.example.shaunreddy.chatterchallenge.view.MainActivity
import com.example.shaunreddy.chatterchallenge.view.MainActivityPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ViewModule::class, PresenterModule::class, DataManagerModule::class ])
@Singleton
interface Component {

    public fun injectView(presenter: MainActivityPresenter)

    public fun injectPresenter(mainActivity: MainActivity)
    public fun injectPresenter(dataManager: DataManager)
    public fun injectDataManager(presenter: MainActivityPresenter)
}