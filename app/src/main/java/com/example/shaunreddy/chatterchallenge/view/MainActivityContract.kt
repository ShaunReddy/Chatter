package com.example.shaunreddy.chatterchallenge.view

import com.example.shaunreddy.chatterchallenge.model.BankDetails

interface MainActivityContract {
    interface IMainActivity {
         fun populateRecyclerView(bankDetails: List<BankDetails>)
         fun handleNetworkError()
         fun showProgressbar(message : String)
    }

    interface IPresenter {
         fun getBankDetails(mainActivity: MainActivity)
         fun populateRecyclerView(bankDetails: List<BankDetails>)
         fun handleError(throwable: Throwable)
    }
}