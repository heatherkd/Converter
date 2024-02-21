package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var ed1: EditText
    private lateinit var ed2: EditText

    var currencies = arrayOf<String?>("USD", "EUR", "GBP")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner1=findViewById(R.id.topSpinner)
        spinner2=findViewById(R.id.bottomSpinner)
        ed1=findViewById(R.id.edTop)
        ed2=findViewById(R.id.edBottom)

        spinner1.onItemSelectedListener = this
        spinner2.onItemSelectedListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            currencies)

        val ad2: ArrayAdapter<*> = ArrayAdapter<Any?>(
            this,
            android.R.layout.simple_spinner_item,
            currencies)

        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item)

        spinner1.adapter=ad
        spinner2.adapter=ad2

        ed1.doOnTextChanged { text, start, before, count ->
            if (ed1.isFocused) {
                val amt = if (ed1.text.isEmpty()) 0.0 else ed1.text.toString().toDouble()
                val convertedCurrency = convertCurrency(
                    amt,
                    spinner1.selectedItem.toString(),
                    spinner2.selectedItem.toString()
                )
                ed2.setText(convertedCurrency.toString())
            }
        }

        ed2.doOnTextChanged { text, start, before, count ->
            if (ed2.isFocused) {
                val amt = if (ed2.text.isEmpty()) 0.0 else ed2.text.toString().toDouble()
                val convertedCurrency = convertCurrency(
                    amt,
                    spinner2.selectedItem.toString(),
                    spinner1.selectedItem.toString()
                )
                ed1.setText(convertedCurrency.toString())
            }
        }

        }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent!!.id){
            R.id.topSpinner -> {
                val amt = if (ed1.text.isEmpty())0.0 else ed1.text.toString().toDouble()
                val convertedCurrency = convertCurrency(
                    amt,
                    spinner1.selectedItem.toString(),
                    spinner2.selectedItem.toString())
                ed2.setText(convertedCurrency.toString())
            }

            R.id.bottomSpinner -> {
                val amt = if (ed2.text.isEmpty())0.0 else ed2.text.toString().toDouble()
                val convertedCurrency = convertCurrency(
                    amt,
                    spinner2.selectedItem.toString(),
                    spinner1.selectedItem.toString())
                ed1.setText(convertedCurrency.toString())
            }
        }
        /*Toast.makeText(applicationContext,
            currencies[position],
            Toast.LENGTH_LONG)
            .show()*/
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    fun convertCurrency(amt: Double, firstCurrency: String, secondCurrency: String): Double {
        val usd = convertOtherToUSD(amt, firstCurrency)
        return converUSDToOther(usd, secondCurrency)

    }

    private fun converUSDToOther(usd: Double, secondCurrency: String): Double {
        return usd * when (secondCurrency){
            "USD" -> 1.0
            "EUR" -> 0.92
            "GBP" -> 0.79

            else -> 0.0
        }

    }

    private fun convertOtherToUSD(amt: Double, firstCurrency: String): Double {
        return amt * when (firstCurrency){
            "USD" -> 1.0
            "EUR" -> 0.92
            "GBP" -> 0.79

            else -> 0.0
        }


    }

}