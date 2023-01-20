package com.shyam.tipcalculator

import android.icu.text.NumberFormat
import android.icu.util.Currency
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()   {

    var fifteenPercent: Button? = null;
    var eighteenPercent: Button? = null;
    var twentyPercent: Button? = null;
    var billamt: EditText? =null;
    var totalamt: TextView? =null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fifteenPercent = findViewById(R.id.option_fifteen_percent) as Button;
        eighteenPercent = findViewById(R.id.option_eighteen_percent) as Button;
        twentyPercent =  findViewById(R.id.option_twenty_percent) as Button;

        billamt=  findViewById(R.id.bill_amount);
        totalamt =  findViewById(R.id.total_result);


        fifteenPercent!!.setOnClickListener{ calculateTip(fifteenPercent!!) }
        eighteenPercent!!.setOnClickListener{ calculateTip(eighteenPercent!!) }
        twentyPercent!!.setOnClickListener{ calculateTip(twentyPercent!!) }


        var money: Double? = null
    }

    fun calculateTip(button:Button) {
        var amt = if(billamt!!.text.isNotEmpty()){billamt!!.text.toString()}else{""}
        var costamt : Double = if(amt.isNotEmpty()){amt.toDouble()}else{0.00}

        val tipPercentage = when (button.id) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * costamt
        var total =tip+costamt ;

        val moneyformat: NumberFormat = NumberFormat.getCurrencyInstance()
        moneyformat.setMaximumFractionDigits(2)
        moneyformat.setCurrency(Currency.getInstance("USD"))

        totalamt!!.text = "Tip: "+ moneyformat.format(tip).toString() + ", Total Bill: "+moneyformat.format(total).toString()
    }
}