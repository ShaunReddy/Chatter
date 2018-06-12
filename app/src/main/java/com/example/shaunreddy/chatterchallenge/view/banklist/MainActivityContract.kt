package com.example.shaunreddy.chatterchallenge.view.banklist

import com.example.shaunreddy.chatterchallenge.model.BankDetails

interface MainActivityContract {
    interface IMainActivity {
        fun populateRecyclerView(bankDetails: List<BankDetails>)
        fun handleNetworkError(message: String)
    }

    interface IPresenter {
        fun getBankDetails()
        fun handleResponse(bankDetails: List<BankDetails>)
        fun handleError(message: String)
    }
}