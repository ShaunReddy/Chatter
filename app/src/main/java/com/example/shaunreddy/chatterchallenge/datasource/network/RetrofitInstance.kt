package com.example.shaunreddy.chatterchallenge.datasource.network

import com.example.shaunreddy.chatterchallenge.utils.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {


    public companion object {
        private lateinit var retrofitIstance : Retrofit;
        public fun getRetrofitInstance() : Retrofit{
            if(retrofitIstance == null){
                retrofitIstance = Retrofit.Builder().baseUrl(Constants.baseUrl).addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
            }
            return retrofitIstance;
        }
    }
}