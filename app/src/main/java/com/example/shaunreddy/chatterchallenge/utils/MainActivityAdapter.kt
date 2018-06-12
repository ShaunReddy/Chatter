package com.example.shaunreddy.chatterchallenge.utils

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shaunreddy.chatterchallenge.R
import com.example.shaunreddy.chatterchallenge.model.BankDetails

class MainActivityAdapter(bankDetailsList : List<BankDetails>, listener : OnItemClickListener, context : Context) : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {
    // Interface with onitemClick method to handle onClick listeners. Implemented in MainActivity
    interface  OnItemClickListener{
        fun onitemClick(bankDetails: BankDetails)
    }
   private var bankDetailsList : List<BankDetails>
    private var listener : OnItemClickListener
    private var context : Context

    init {
        this.bankDetailsList = bankDetailsList
        this.listener = listener
        this.context = context
    }


     // Overriden method, inflates a layout and return new ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_view, parent, false)
        return ViewHolder(view)
    }


     // Overriden method, returns the size of the list to create a list

    override fun getItemCount(): Int {
        return bankDetailsList.size
    }
   // overriden method, binds views to data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bankDetails = bankDetailsList[position]
        val amount =  context.getString(R.string.dollor_sign) + bankDetails.getAmount().toString()
        val name = bankDetails.getName()

        holder.nameTv.text = name
        holder.amountTv.text = amount
        holder.bind(bankDetails, listener)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTv : TextView = itemView.findViewById(R.id.tv_name)
        var amountTv : TextView = itemView.findViewById(R.id.tv_amount)
        /**
         * handles the onItem Click listener
         * @param bankDetails: BankDetails
         * @param listener : OnItemClickListener
         */
        fun bind(bankDetails: BankDetails, listener : OnItemClickListener) {

             itemView.setOnClickListener { listener.onitemClick(bankDetails) }


        }
    }
}