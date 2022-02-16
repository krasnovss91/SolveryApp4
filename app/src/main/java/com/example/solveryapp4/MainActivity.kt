package com.example.solveryapp4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList())

        //поправить, чтобы отображались все элементы (зависимость в gradle добавил)
        //добавить возможность редактирования, добавления и удаления товара
    }

    private fun productList():List<Product> = listOf(
        Product(R.drawable.ic_launcher_background,"Картофель","ООО Интегра",18),
        Product(R.drawable.ic_launcher_foreground,"Чай","ИП Абрамян А.Г.",9),
        Product(R.drawable.ic_launcher_background,"Яйца","с.Зелёное",22),
        Product(R.drawable.ic_launcher_foreground,"Молоко","с.Зелёное",20),
        Product(R.drawable.ic_launcher_background,"Макароны","Тольяттинский хлебозавод",15)
    )
}