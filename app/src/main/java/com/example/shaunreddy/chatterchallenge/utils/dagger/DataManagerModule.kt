package com.example.shaunreddy.chatterchallenge.utils.dagger

import com.example.shaunreddy.chatterchallenge.datasource.IDataManager
import com.example.shaunreddy.chatterchallenge.datasource.network.DataManager
import dagger.Module
import dagger.Provides

@Module
class DataManagerModule {
    @Provides
    fun getDataManagerInstance() : DataManager{
        return DataManager();
    }
}