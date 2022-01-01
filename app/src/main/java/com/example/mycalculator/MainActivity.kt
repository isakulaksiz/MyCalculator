package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isLastNumeric: Boolean = false
    var isLastDoc = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        tv_input.append((view as Button).text)
        isLastNumeric = true
    }

    fun onClear(view: View){
        tv_input.text=""
        isLastNumeric = false
        isLastDoc = false
    }

    fun onDecimalPoint(view: View){
        if(isLastNumeric && !isLastDoc){
            tv_input.append(".")
            isLastNumeric = false
            isLastDoc = true
        }
    }

    private fun isOperatorAdded(value: String): Boolean{
        return if(value.startsWith("-"))
            false
        else
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
    }

    fun onOperator(view: View){
        if(isLastNumeric || !isOperatorAdded(tv_input.text.toString())){
            tv_input.append((view as Button).text)
            isLastNumeric = false
            isLastDoc = false
        }
    }
}