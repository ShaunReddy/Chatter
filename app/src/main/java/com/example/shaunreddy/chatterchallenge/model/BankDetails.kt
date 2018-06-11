package com.example.shaunreddy.chatterchallenge.model

class BankDetails {
    private var name: String? = null
    private var amount: Double = 0.toDouble()
    private var ROI: Double = 0.toDouble()
    private var id: Int = 0

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getAmount(): Double {
        return amount
    }

    fun setAmount(amount: Double) {
        this.amount = amount
    }

    fun getROI(): Double {
        return ROI
    }

    fun setROI(ROI: Double) {
        this.ROI = ROI
    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }
}