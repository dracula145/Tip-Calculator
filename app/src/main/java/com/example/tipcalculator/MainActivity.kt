package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip(){

        val cost=binding.costOfServiceEditText.text.toString().toDoubleOrNull()
        if(cost==null){
            Toast.makeText(this, "Enter the Cost", Toast.LENGTH_SHORT).show()
            return
        }

        val tipPercentage= when(binding.tipOptions.checkedRadioButtonId){
            R.id.twenty_percent -> 0.2
            R.id.eighteen_percent -> 0.18
            else     -> 0.15
        }

      var tip= cost*tipPercentage

       val round= binding.roundUpSwitch.isChecked
        if(round) tip=ceil(tip)
        binding.showAmount.text= "Tip Amount: $tip"

    }
}