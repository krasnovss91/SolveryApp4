package com.example.solveryapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class EditActivity : AppCompatActivity() {//здесь редактирование элемента списка
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

    val name = findViewById<EditText>(R.id.nameEdit1)
    val producer = findViewById<EditText>(R.id.producerEdit1)
    val cost = findViewById<EditText>(R.id.costEdit1)


    }
}