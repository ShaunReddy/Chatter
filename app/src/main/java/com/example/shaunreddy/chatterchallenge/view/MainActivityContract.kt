package com.example.shaunreddy.chatterchallenge.view

import com.example.shaunreddy.chatterchallenge.model.BankDetails

interface MainActivityContract {
    interface IMainActivity {
        public fun populateRecyclerView()
    }

    interface IPresenter {
        public fun getBankDetails()
        public fun populateRecyclerView(bankDetails: List<BankDetails>)
    }
}