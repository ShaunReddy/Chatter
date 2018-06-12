package com.example.shaunreddy.chatterchallenge.model

import android.os.Parcel
import android.os.Parcelable
import java.math.BigDecimal

class BankDetails() : Parcelable{
    private var name: String? = null
    private var amount: BigDecimal = 0.toBigDecimal()
    private var ROI: BigDecimal = 0.toBigDecimal()

    private var id: Int = 0

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        id = parcel.readInt()
        amount = parcel.readString().toBigDecimal()
        ROI = parcel.readString().toBigDecimal()
    }

    fun getName(): String? {
        return name
    }



    fun getAmount(): BigDecimal {
        return amount
    }



    fun getROI(): BigDecimal {
        return ROI
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(id)
        parcel.writeString(amount.toString())
        parcel.writeString(ROI.toString())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BankDetails> {
        override fun createFromParcel(parcel: Parcel): BankDetails {
            return BankDetails(parcel)
        }

        override fun newArray(size: Int): Array<BankDetails?> {
            return arrayOfNulls(size)
        }
    }
}