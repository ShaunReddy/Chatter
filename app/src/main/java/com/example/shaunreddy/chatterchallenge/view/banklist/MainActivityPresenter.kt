package com.example.shaunreddy.chatterchallenge.view.banklist

import com.example.shaunreddy.chatterchallenge.datasource.IDataManager
import com.example.shaunreddy.chatterchallenge.datasource.DataManager
import com.example.shaunreddy.chatterchallenge.model.BankDetails
import retrofit2.Retrofit


class MainActivityPresenter(mainActivity: MainActivityContract.IMainActivity, retrofit: Retrofit) : MainActivityContract.IPresenter {


    private var mainActivity: MainActivityContract.IMainActivity
    private var iDataManager: IDataManager
    private var retrofit: Retrofit

    init {
        this.retrofit = retrofit
        this.mainActivity = mainActivity
        this.iDataManager = DataManager(this, retrofit)
    }


    override fun getBankDetails() {
        iDataManager.getBankDetails()
    }

    /**
     * @param bankDetails : List<BankDetails>
     *     retrun void
     */

    override fun handleResponse(bankDetails: List<BankDetails>) {
        mainActivity.populateRecyclerView(bankDetails)
    }

    override fun handleError(message: String) {
        mainActivity.handleNetworkError(message)
    }
}