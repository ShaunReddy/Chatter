package com.example.shaunreddy.chatterchallenge.view

import android.view.View
import com.example.shaunreddy.chatterchallenge.datasource.network.DataManager
import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.utils.dagger.DaggerComponent
import com.example.shaunreddy.chatterchallenge.utils.dagger.PresenterModule
import com.example.shaunreddy.chatterchallenge.utils.dagger.ViewModule
import javax.inject.Inject

class MainActivityPresenter : MainActivityContract.IPresenter {
    @Inject
    lateinit var mainActivityPresenter: MainActivityPresenter
    @Inject
    lateinit var dataManager: DataManager

    init {
        DaggerComponent.builder().build().injectView(this)
        DaggerComponent.builder().build().injectDataManager(this)
    }

    public override fun getBankDetails() {
        dataManager.getBankDetails()
    }

    public override fun populateRecyclerView(bankDetails: List<BankDetails>) {

    }
}