package com.example.solveryapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product2)

        val name = findViewById<View>(R.id.nameEdit)
        val producer = findViewById<View>(R.id.producerEdit)
        val cost = findViewById<View>(R.id.costEdit)

        val saveProduct = findViewById<Button>(R.id.saveProduct)
    }
}