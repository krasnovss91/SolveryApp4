package com.example.solveryapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ChangeActivity : AppCompatActivity() {
    //сюда 2 кнопки, что сделать с текущим элементом
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val editButton = findViewById<Button>(R.id.editButton)

        deleteButton.setOnClickListener(object : View.OnClickListener {//удалить
            override fun onClick(p0: View?) {

            }
        })

        editButton.setOnClickListener(object : View.OnClickListener{//редактировать
            override fun onClick(p0: View?) {

            }
        })
    }
}