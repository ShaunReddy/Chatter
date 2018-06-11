package com.example.shaunreddy.chatterchallenge.datasource.network

import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.utils.Constants
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET(Constants.endUrl)
    fun getBankDetails() : Observable<BankDetails>
}