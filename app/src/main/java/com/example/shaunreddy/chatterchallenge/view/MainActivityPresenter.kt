package com.example.shaunreddy.chatterchallenge.view

import com.example.shaunreddy.chatterchallenge.datasource.IDataManager
import com.example.shaunreddy.chatterchallenge.datasource.DataManager
import com.example.shaunreddy.chatterchallenge.model.BankDetails


class MainActivityPresenter(mainActivity: MainActivityContract.IMainActivity) : MainActivityContract.IPresenter {



     var mainActivity: MainActivityContract.IMainActivity
     var iDataManager: IDataManager

    init {
        this.mainActivity = mainActivity
        this.iDataManager = DataManager(this)
        //DaggerComponent.builder().dataManagerModule(DataManagerModule(this)).build().injectDataManager(this)
    }

     override fun getBankDetails(mainActivity: MainActivity) {
         this.mainActivity = mainActivity

        iDataManager.getBankDetails()
    }

     override fun populateRecyclerView(bankDetails: List<BankDetails>) {
        mainActivity.populateRecyclerView(bankDetails)
    }
    override fun handleError(throwable: Throwable) {

    }
}