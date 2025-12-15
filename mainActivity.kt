package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSub = findViewById<Button>(R.id.btnSub)
        val btnMul = findViewById<Button>(R.id.btnMul)
        val btnDiv = findViewById<Button>(R.id.btnDiv)

        btnAdd.setOnClickListener {
            calculate(etNum1, etNum2, tvResult, "+")
        }
        btnSub.setOnClickListener {
            calculate(etNum1, etNum2, tvResult, "-")
        }
        btnMul.setOnClickListener {
            calculate(etNum1, etNum2, tvResult, "*")
        }
        btnDiv.setOnClickListener {
            calculate(etNum1, etNum2, tvResult, "/")
        }
    }

    private fun calculate(etNum1: EditText, etNum2: EditText, tvResult: TextView, operator: String) {
        val num1 = etNum1.text.toString()
        val num2 = etNum2.text.toString()

        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val a = num1.toDouble()
        val b = num2.toDouble()
        var result = 0.0

        when (operator) {
            "+" -> result = a + b
            "-" -> result = a - b
            "*" -> result = a * b
            "/" -> {
                if (b == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                result = a / b
            }
        }
        tvResult.text = "Result: $result"
    }
}
