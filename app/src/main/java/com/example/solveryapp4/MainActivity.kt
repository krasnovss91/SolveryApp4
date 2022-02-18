package com.example.solveryapp4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solveryapp4.databinding.ActivityMainBinding

const val PRODUCT = "KEY_PRODUCT"

class MainActivity : AppCompatActivity(), OnProductSelected {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList(), this)

        val addButton = findViewById<Button>(R.id.addProduct)

        val saveIntent = Intent(this, ProductActivity::class.java)



        addButton.setOnClickListener(object: View.OnClickListener{//достать результат из другой activity и добавить в список
            override fun onClick(p0: View?) {
              //  startActivity(saveIntent)
            startActivityForResult(saveIntent, 1)
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

    override fun onSelect(product: Product) {//здесь вызвать changeActivity
        val changeIntent = Intent(this,ChangeActivity::class.java)
        changeIntent.putExtra(PRODUCT,product)
        startActivity(changeIntent)

    }
}