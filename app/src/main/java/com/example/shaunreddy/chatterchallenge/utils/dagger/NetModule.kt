package com.example.shaunreddy.chatterchallenge.utils.dagger

import com.example.shaunreddy.chatterchallenge.utils.Constants
import dagger.Module
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


@Module
class NetModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
    }
}