package com.example.shaunreddy.chatterchallenge.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import com.example.shaunreddy.chatterchallenge.R
import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.utils.Constants
import com.example.shaunreddy.chatterchallenge.utils.MainActivityAdapter
import com.example.shaunreddy.chatterchallenge.view.details.DetailsScreen
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.IMainActivity {



    private lateinit var iPresenter: MainActivityContract.IPresenter
    private lateinit var mainActivityAdapter: MainActivityAdapter
    private lateinit var progressBar : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()


    }

   private fun init(){
        progressBar = ProgressBar(this)
        iPresenter = MainActivityPresenter(this)
        iPresenter.getBankDetails(this)

    }
    override fun showProgressbar(message: String) {

    }
     override fun populateRecyclerView(bankDetails: List<BankDetails>){
         mainActivityAdapter = MainActivityAdapter(bankDetails, object : MainActivityAdapter.OnItemClickListener{
             override fun onitemClick(bankDetails: BankDetails) {
                 val intent = Intent(baseContext, DetailsScreen::class.java)
                 val bundle = Bundle()
                 bundle.putParcelable(Constants.BANK_DETAILS, bankDetails)
                 intent.putExtras(bundle)
                 startActivity(intent)
             }
         })
         rv_bankDetails.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
         rv_bankDetails.setHasFixedSize(true)
         rv_bankDetails.adapter = mainActivityAdapter

    }

    override fun handleNetworkError() {

    }
}
