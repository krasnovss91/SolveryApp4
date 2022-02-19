package com.example.solveryapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity() {//здесь редактирование элемента списка
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

    val name = findViewById<EditText>(R.id.nameEdit1)
    val producer = findViewById<EditText>(R.id.producerEdit1)
    val cost = findViewById<EditText>(R.id.costEdit1)

    val editButton = findViewById<Button>(R.id.saveProduct1)
    val product = intent.getParcelableExtra<Product>(PRODUCT)//разложить по EditText для редактирования

   // name.text = product.name

    editButton.setOnClickListener(object : View.OnClickListener{//вернуть отредактированный экземпляр в главную activity
        override fun onClick(p0: View?) {

        }
    })

    }
}