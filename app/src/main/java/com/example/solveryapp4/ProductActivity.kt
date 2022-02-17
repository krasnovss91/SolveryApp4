package com.example.solveryapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product2)

        var name = findViewById(R.id.nameEdit) as EditText
        var producer = findViewById(R.id.producerEdit) as EditText
        var cost = findViewById(R.id.costEdit) as EditText


        val product = Product(R.drawable.ic_launcher_background, name.text.toString(), producer.text.toString(), cost.text.toString().toInt())

        val saveProduct = findViewById<Button>(R.id.saveProduct)

        //здесь собрать экземпляр product и кинуть в MainActivity

        saveProduct.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {

            }
        })
    }
}