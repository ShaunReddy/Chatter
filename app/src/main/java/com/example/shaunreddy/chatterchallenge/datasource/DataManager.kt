package com.example.shaunreddy.chatterchallenge.datasource

import com.example.shaunreddy.chatterchallenge.datasource.network.APIService
import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.view.banklist.MainActivityContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class DataManager(presenter: MainActivityContract.IPresenter, retrofit: Retrofit) : IDataManager{


  private var retrofit : Retrofit
  private var ipresenter: MainActivityContract.IPresenter = presenter
   init {
       this.retrofit = retrofit
   }


     override fun getBankDetails(){

          retrofit.create(APIService::class.java).getBankDetails()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(
                         { result -> showResult(result) },
                         { error -> showError(error.message) }
                 )
     }

    private fun showError(message: String?) {
        ipresenter.handleError(message!!)

    }

    private fun showResult(result: List<BankDetails>?) {
        ipresenter.handleResponse(result!!)    }

}





