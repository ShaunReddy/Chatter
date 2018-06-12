package com.example.shaunreddy.chatterchallenge.datasource.network

import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET(Constants.END_URL)
    fun getBankDetails() : Call<List<BankDetails>>
}