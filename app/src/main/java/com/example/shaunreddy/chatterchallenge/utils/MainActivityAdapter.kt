package com.example.shaunreddy.chatterchallenge.utils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.shaunreddy.chatterchallenge.R
import com.example.shaunreddy.chatterchallenge.model.BankDetails

class MainActivityAdapter(bankDetailsList : List<BankDetails>, listener : OnItemClickListener) : RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {

    interface  OnItemClickListener{
        fun onitemClick(bankDetails: BankDetails)
    }
   private var bankDetailsList : List<BankDetails>
    private var listener : OnItemClickListener

    init {
        this.bankDetailsList = bankDetailsList
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bankDetailsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bankDetails = bankDetailsList[position]
        val amount = Constants.DOLLAR_SIGN+bankDetails.getAmount().toString()
        val name = bankDetails.getName()
        holder.nameTv.text = name
        holder.amountTv.text = amount
        holder.bind(bankDetails, listener)
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTv : TextView = itemView.findViewById(R.id.tv_name)
        var amountTv : TextView = itemView.findViewById(R.id.tv_amount)
        fun bind(bankDetails: BankDetails, listener : OnItemClickListener){
        itemView.setOnClickListener { listener.onitemClick(bankDetails) }
        }
    }
}