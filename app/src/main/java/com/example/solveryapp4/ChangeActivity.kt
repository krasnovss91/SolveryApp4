package com.example.solveryapp4

import android.content.Intent
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

        //поймать экземпляр product и передать дальше
        val product = intent.getParcelableExtra<Product>(PRODUCT)
        val editIntent = Intent(this, EditActivity::class.java)

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