package com.example.converter

import android.net.Uri.Builder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    /*private lateinit var binding: ActivityMainBinding
    private lateinit var selectedUnit:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= AppCompatActivity(layoutInflater)
        setContentView(binding.root)
        val df = DecimalFormat("#.##")
        selectedUnit = "Fahrenheit"
        binding.selectType.setOnClickListener(){
            showAlertDialog()
        }

        binding.editInput.addTextChangedListener(){
            val resultText:String
            var inputVal = binding.editInput.text.toString()
            if (inputVal.isNotEmpty()){
                var doubleInput = inputVal.toDouble()
                if (selectedUnit == "Fahrenheit"){
                    resultText = df.format((doubleInput-32)*5/9)
                    binding.textResultType.text = "Celsius"
                }else{
                    resultText=df.format((doubleInput*9/5)+32)
                    binding.textResultType.text="Fahrenheit"
                }
                binding.textResultType.text=resultText
            }
        }
    }

    private fun showAlertDialog() {
        val alertDialog:Builder = Builder(this@MainActivity)
        alertDialog.setTitle("Select Unit")
        val items = arrayOf("Fahrenheit", "Celsius")
        val checkedItem = -1
        alertDialog.setSingleChoiceItems(items, checkedItem,
            DialogInterface.OnClickListener { dialog, which ->
                selectedUnit = items[which]
                binding.textType.setText(items[which])
            })
        alertDialog.setPositiveButton(
            android.R.string.ok,
            DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
        val alert: AlertDialog = alertDialog.create()
        alert.setCanceledOnTouchOutside(false)
        alert.show()
    }*/

}