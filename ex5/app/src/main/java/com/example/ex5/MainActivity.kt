package com.example.ex5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    private val buttonPlus: Button by lazy { findViewById(R.id.button) }
    private val buttonMinus: Button by lazy { findViewById(R.id.button2) }
    private val buttonMultiply: Button by lazy { findViewById(R.id.button3) }
    private val buttonDivide: Button by lazy { findViewById(R.id.button4) }
    private val buttonEqual: Button by lazy { findViewById(R.id.button5) }


    private val firstValue: EditText by lazy { findViewById(R.id.editTextText2) }
    private val secondValue: EditText by lazy { findViewById(R.id.editTextText) }
    private val resultView: TextView by lazy { findViewById(R.id.textView) }
    private val operationView: TextView by lazy { findViewById(R.id.textvalue) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            buttonPlus.setOnClickListener { calculate("+") }
            buttonMinus.setOnClickListener { calculate("-") }
            buttonMultiply.setOnClickListener { calculate("*") }
            buttonDivide.setOnClickListener { calculate("/") }



    }
    fun calculate(operation: String) {
        buttonEqual.setOnClickListener {
            val num1 = firstValue.text.toString().toDoubleOrNull()
            val num2 = secondValue.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                resultView.text = "Invalid Input"
                return@setOnClickListener
            }

            operationView.text = operation
            val result: Double = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/"-> if (num2 !=0.0) num1 / num2 else {
                    resultView.text = "u can't enter 0"
                    return@setOnClickListener // Exit early if the operation is invalid
                }
                else -> {
                    resultView.text = "Invalid Operation"
                    return@setOnClickListener // Exit early if the operation is invalid
                }
            }
            resultView.text = result.toString()
        }



    }

}
