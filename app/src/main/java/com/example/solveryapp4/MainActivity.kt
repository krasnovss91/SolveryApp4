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

        val productList = mutableListOf(
            Product(R.drawable.ic_launcher_background, "Картофель", "ООО Интегра", 18),
            Product(R.drawable.ic_launcher_foreground, "Чай", "ИП Абрамян А.Г.", 9),
            Product(R.drawable.ic_launcher_background, "Яйца", "с.Зелёное", 22),
            Product(R.drawable.ic_launcher_foreground, "Молоко", "с.Зелёное", 20),
            Product(R.drawable.ic_launcher_background, "Макароны", "Тольяттинский хлебозавод", 15)
        )

        val recyclerView: RecyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ProductAdapter(productList, this)

        val addButton = findViewById<Button>(R.id.addProduct)

        val saveIntent = Intent(this, ProductActivity::class.java)

        addButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                startActivityForResult(saveIntent, 1)// сложить результат в список товаров через Request-код

                //val arguments = saveIntent.extras
                val arguments = intent.extras
                val data = arguments?.get(PRODUCT)
                productList.add(data as Product)//NPE
                //val result = setResult(1)
              //  productList.add(result)
               //https://startandroid.ru/en/lessons/520-making-activity-return-result-with-startactivityforresult-method.html
                //переопределить метод onActivityResult
            }
        })

    }

/*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

 */
    override fun onSelect(product: Product) {
        val editIntent = Intent(this, EditActivity::class.java)
        editIntent.putExtra(PRODUCT, product)
        startActivity(editIntent)

    }

    fun delete(product: Product, productList: MutableList<Product>){//вызывать при нажатии на кнопку удаления
        productList.remove(product)
    }
}