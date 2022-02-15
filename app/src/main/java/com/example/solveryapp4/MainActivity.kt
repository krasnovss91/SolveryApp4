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

    }

    private fun productList():List<Product> = listOf(
        Product(R.drawable.ic_launcher_background,"Картофель","",18),
        Product(R.drawable.ic_launcher_background,"Чай","",9),
        Product(R.drawable.ic_launcher_background,"Яйца","",22),
        Product(R.drawable.ic_launcher_background,"Молоко","",20),
        Product(R.drawable.ic_launcher_background,"Макароны","",15)
    )
}