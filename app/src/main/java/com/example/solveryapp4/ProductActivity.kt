package com.example.solveryapp4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product2)

        val name = findViewById(R.id.nameEdit) as EditText
        val producer = findViewById(R.id.producerEdit) as EditText
        val cost = findViewById(R.id.costEdit) as EditText


        val product = Product(R.drawable.ic_launcher_background, name.text.toString(), producer.text.toString(), cost.text.toString().toInt())

        val saveProduct = findViewById<Button>(R.id.saveProduct)
        val intent = Intent()

        saveProduct.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                intent.putExtra(PRODUCT,product)
                setResult(RESULT_OK, intent)
                finish()

            }
        })
    }
}