package com.example.calculatorv2

import android.icu.text.DecimalFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var n = ""
    var number1 = ""
    var number2 = true
    var check = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        num0.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}0")
            else {
                show.text = "0"
                number2 = true
            }
        }
        num1.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}1")
            else {
                show.text = "1"
                number2 = true
            }
        }
        num2.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}2")
            else {
                show.text = "2"
                number2 = true
            }
        }
        num3.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}3")
            else {
                show.text = "3"
                number2 = true
            }
        }
        num4.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}4")
            else {
                show.text = "4"
                number2 = true
            }
        }
        num5.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}5")
            else {
                show.text = "5"
                number2 = true
            }
        }
        num6.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}6")
            else {
                show.text = "6"
                number2 = true
            }
        }
        num7.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}7")
            else {
                show.text = "7"
                number2 = true
            }
        }
        num8.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}8")
            else {
                show.text = "8"
                number2 = true
            }
        }
        num9.setOnClickListener{
            if (number2)
                show.text = formatDecimal("${show.text}9")
            else {
                show.text = "9"
                number2 = true
            }
        }
        btdel.setOnClickListener {
            show.text = show.text.toString().dropLast(1).ifEmpty { "0" }
        }
        btplus.setOnClickListener {
            n = "+"
            if (n != "" && number1 == "") {
                number1 = show.text.toString()
            }
            if (check) {
                compute()
                number1 = show.text.toString()
            }
            check = true
            number2 = false
        }
        btmin.setOnClickListener {
            n = "-"
            if (n != "" && number1 == "") {
                number1 = show.text.toString()
            }
            if (check) {
                compute()
                number1 = show.text.toString()
            }
            check = true
            number2 = false
        }
        btdiv.setOnClickListener {
            n = "/"
            if (n != "" && number1 == "") {
                number1 = show.text.toString()
            }
            if (check) {
                compute()
                number1 = show.text.toString()
            }
            check = true
            number2 = false
        }
        btmult.setOnClickListener {
            n = "*"
            if (n != "" && number1 == "") {
                number1 = show.text.toString()
            }
            if (check) {
                compute()
                number1 = show.text.toString()
            }
            check = true
            number2 = false
        }
        btmod.setOnClickListener {
            n = "%"
            if (n != "" && number1 == "") {
                number1 = show.text.toString()
            }
            if (check) {
                compute()
                number1 = show.text.toString()
            }
            check = true
            number2 = false
        }
        btt.setOnClickListener{
            compute ()
            n = ""
            number1 = ""
            check = false
        }
        btclear.setOnClickListener {
            n = ""
            number1 = ""
            number2 = true
            show.text = "0"
            check = false
        }
        btdot.setOnClickListener {
            if (!show.text.toString().contains(".")&& show.text.toString().isNotEmpty()) {
                show.text = "${show.text}."
            }
        }

    }
    fun compute () {
        var number2 = show.text.toString()
        if (n != "" && number2 != "") {
            if (n == "+") {
                println(number1 + number2)
                show.text =
                    formatDecimal((number1.toDouble() + number2.toDouble()).toString())
            } else if (n == "-") {
                show.text =
                    formatDecimal((number1.toDouble() - number2.toDouble()).toString())
            } else if (n == "*") {
                show.text =
                    formatDecimal((number1.toDouble() * number2.toDouble()).toString())
            } else if (n == "/") {
                if (number2 == "0" || number2 == "") {
                    show.text = "ERROR"
                    return@compute
                }
                show.text =
                    formatDecimal((number1.toDouble() / number2.toDouble()).toString())
            } else if (n == "%") {
                if (number2 == "0" || number2 == "") {
                    show.text = "ERROR"
                    return@compute
                }
                show.text =
                    formatDecimal((number1.toDouble() % number2.toDouble()).toString())
            }
        }
    }
    private fun formatDecimal(num: String): String {
        val format = DecimalFormat("0.#######");
        return format.format(num.ifEmpty { "0" }.toDouble())
    }
}