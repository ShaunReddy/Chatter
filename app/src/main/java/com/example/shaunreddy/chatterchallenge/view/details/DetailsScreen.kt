package com.example.shaunreddy.chatterchallenge.view.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.shaunreddy.chatterchallenge.R
import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.utils.Constants
import kotlinx.android.synthetic.main.activity_details_screen.*

class DetailsScreen : AppCompatActivity() {
    private lateinit var bankDetails : BankDetails
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_screen)
      val bundle = intent.extras
      bankDetails = bundle.getParcelable(Constants.BANK_DETAILS)
        if(bankDetails.getROI() < 0.toBigDecimal()){
            cv_detailsScreen.setCardBackgroundColor(ContextCompat.getColor(this, R.color.colorRed))
        }
        else{
            cv_detailsScreen.setCardBackgroundColor(ContextCompat.getColor(this, R.color.colorGreen))
        }
        details_tv_name.text = bankDetails.getName()
        val amount = Constants.DOLLAR_SIGN+bankDetails.getAmount()
        details_tv_amount.text = amount
        val ROI =  Constants.ROI+bankDetails.getROI()
        details_tv_ROI.text = ROI
    }
}
