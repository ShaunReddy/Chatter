package com.example.shaunreddy.chatterchallenge.view.bankdetails

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.shaunreddy.chatterchallenge.R
import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.utils.Constants
import kotlinx.android.synthetic.main.activity_details_screen.*

class DetailsScreen : AppCompatActivity() {
    private lateinit var bankDetails: BankDetails
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_screen)
        init()
    }
   // Inilization logic
    private fun init() {
        val bundle = intent.extras
        bankDetails = bundle.getParcelable(Constants.BANK_DETAILS)

       // Compare ROI with zero, make background green if ROI is greater than or equal to 0 and red when ROI is less than 0
       val res = if (bankDetails.getROI() < 0.toBigDecimal()) R.color.colorRed else R.color.colorGreen
       cv_detailsScreen.setCardBackgroundColor(ContextCompat.getColor(this, res))
        details_tv_name.text = bankDetails.getName()
        val amount =  getString(R.string.dollor_sign) +bankDetails.getAmount().toString()
        details_tv_amount.text = amount
        val ROI = bankDetails.getROI().toString()
        details_tv_ROI.text = ROI
    }
}
