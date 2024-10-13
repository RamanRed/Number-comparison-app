package com.example.counterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.counterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Using View Binding to access views
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout with View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set an onClickListener for the "Compare" button
        binding.btnCompare.setOnClickListener {
            compareNumbers()
        }
    }

    // Function to compare two numbers
    private fun compareNumbers() {
        // Get the input values from the EditText fields
        val num1Text = binding.etNumber1.text.toString()
        val num2Text = binding.etNumber2.text.toString()

        // Check if both inputs are not empty
        if (num1Text.isNotEmpty() && num2Text.isNotEmpty()) {
            val num1 = num1Text.toIntOrNull()
            val num2 = num2Text.toIntOrNull()

            // Check if input values are valid integers
            if (num1 != null && num2 != null) {
                val result = when {
                    num1 > num2 -> "Number 1 ($num1) is greater than Number 2 ($num2)"
                    num1 < num2 -> "Number 2 ($num2) is greater than Number 1 ($num1)"
                    else -> "Both numbers are equal"
                }
                // Display the result in the TextView
                binding.tvResult.text = result
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Both fields must be filled", Toast.LENGTH_SHORT).show()
        }
    }
}
