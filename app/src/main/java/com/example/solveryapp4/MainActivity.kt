package com.example.solveryapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList())


        val buttonDelete = findViewById<Button>(R.id.buttonDelete)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)

        //кнопки удалить и добавить, для редактирования вызывать новую activity


        buttonDelete.setOnClickListener(object : View.OnClickListener {//описать удаление элемента
            override fun onClick(p0: View?) {

            }
        })

        buttonAdd.setOnClickListener(object : View.OnClickListener{//описать добавление нового элемента в список
            override fun onClick(p0: View?) {

            }
        })
    }

    private fun productList():List<Product> = listOf(
        Product(R.drawable.ic_launcher_background,"Картофель","ООО Интегра",18),
        Product(R.drawable.ic_launcher_foreground,"Чай","ИП Абрамян А.Г.",9),
        Product(R.drawable.ic_launcher_background,"Яйца","с.Зелёное",22),
        Product(R.drawable.ic_launcher_foreground,"Молоко","с.Зелёное",20),
        Product(R.drawable.ic_launcher_background,"Макароны","Тольяттинский хлебозавод",15)
    )
}