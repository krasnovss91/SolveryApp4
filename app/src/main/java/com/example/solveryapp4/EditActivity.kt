package com.example.solveryapp4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {
    //здесь редактирование элемента списка
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val name = findViewById<EditText>(R.id.nameEdit1)
        val producer = findViewById<EditText>(R.id.producerEdit1)
        val cost = findViewById<EditText>(R.id.costEdit1)

        val editButton = findViewById<Button>(R.id.saveProduct1)
        val product =
            intent.getParcelableExtra<Product>(PRODUCT)


        name.setText(product?.name)
        producer.setText(product?.producer)
        cost.setText(product?.cost.toString())

        val image = product?.avatar

        val intent = Intent(this, MainActivity::class.java)
        editButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
               val result = image?.let { Product(it,name.text.toString(),producer.text.toString(),cost.text.toString().toInt()) }

                intent.putExtra(PRODUCT,result)
                startActivityForResult(intent, 1)
               // finish()
            }
        })

    }
}