package com.example.shaunreddy.chatterchallenge.datasource.network

import com.example.shaunreddy.chatterchallenge.utils.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {


     companion object {
        private lateinit var retrofitIstance : Retrofit
         fun getRetrofitInstance() : Retrofit{

                retrofitIstance = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

            return retrofitIstance
        }
    }
}