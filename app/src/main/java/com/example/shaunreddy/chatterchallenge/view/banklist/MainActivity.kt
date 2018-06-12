package com.example.shaunreddy.chatterchallenge.view.banklist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.example.shaunreddy.chatterchallenge.R
import com.example.shaunreddy.chatterchallenge.base.CharterApp
import com.example.shaunreddy.chatterchallenge.model.BankDetails
import com.example.shaunreddy.chatterchallenge.utils.Constants
import com.example.shaunreddy.chatterchallenge.utils.MainActivityAdapter
import com.example.shaunreddy.chatterchallenge.utils.networkutil.NetworkConnectivity
import com.example.shaunreddy.chatterchallenge.view.bankdetails.DetailsScreen
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.IMainActivity {


    @Inject
    lateinit var retrofit: Retrofit
    private lateinit var networkConnectivity: NetworkConnectivity
    private lateinit var iPresenter: MainActivityContract.IPresenter
    private lateinit var mainActivityAdapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as CharterApp).getNetComponent()!!.inject(this)

    }

    override fun onStart() {
        super.onStart()
        init()
    }

    // initializing logic
    private fun init() {

        networkConnectivity = NetworkConnectivity()
        showSnackBar(networkConnectivity.checkNetwrokConnection(this))
        iPresenter = MainActivityPresenter(this, retrofit)
        iPresenter.getBankDetails()

    }

    /**
     * @param checkNetwrokConnection boolean
     * @return void
     */
    private fun showSnackBar(checkNetwrokConnection: Boolean) {
        if (!checkNetwrokConnection)
            Snackbar.make(coordinatorLayout, getString(R.string.network_error_message), Snackbar.LENGTH_LONG).show()
    }

    /**
     * @param bankDetails List<BankDetails>
     * @return void
     */
    // Populates Recycler view and handles onItemClickListeners
    override fun populateRecyclerView(bankDetails: List<BankDetails>) {
        mainActivityAdapter = MainActivityAdapter(bankDetails, object : MainActivityAdapter.OnItemClickListener {
            override fun onitemClick(bankDetails: BankDetails) {
                val intent = Intent(baseContext, DetailsScreen::class.java)
                val bundle = Bundle()
                bundle.putParcelable(Constants.BANK_DETAILS, bankDetails)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }, this)
        rv_bankDetails.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_bankDetails.setHasFixedSize(true)
        rv_bankDetails.adapter = mainActivityAdapter

    }

    /** Handles network error by showing a
     * @param message : String, message from throwable
     * @return void
     */
    override fun handleNetworkError(message: String) {
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG).show()
    }
}
