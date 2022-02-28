package com.example.solveryapp4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.solveryapp4.Generator.generateId
import com.example.solveryapp4.databinding.ActivityMainBinding

const val PRODUCT = "KEY_PRODUCT"
const val REQUEST_CODE_ADD = 101
const val REQUEST_CODE_EDIT = 102

object Generator {
    private var id: Int = 0

    fun generateId():Int{
        id += 1
        return id
    }
}

class MainActivity : AppCompatActivity(), OnProductSelected, OnProductDeleted {

    private val adapter = ProductAdapter(this, this)

    val productList = mutableListOf(
        Product(R.drawable.ic_launcher_background, "Картофель", "ООО Интегра", 18,generateId()),
        Product(R.drawable.ic_launcher_foreground, "Чай", "ИП Абрамян А.Г.", 9, generateId()),
        Product(R.drawable.ic_launcher_background, "Яйца", "с.Зелёное", 22, generateId()),
        Product(R.drawable.ic_launcher_foreground, "Молоко", "с.Зелёное", 20, generateId()),
        Product(R.drawable.ic_launcher_background, "Макароны", "Тольяттинский хлебозавод", 15, generateId())
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.productList).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            this@MainActivity.adapter.setProducts(productList)
        }


        val addButton = findViewById<Button>(R.id.addProduct)


        val saveIntent = Intent(this, ProductActivity::class.java)


        addButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // startActivityForResult(saveIntent, 1)// сложить результат в список товаров через Request-код

                startActivity(saveIntent)
                //val arguments = saveIntent.extras
                val arguments = intent.extras
                // val data = onActivityResult(1,1,saveIntent)//kotlin.Unit cannot be cast to com.example.solveryapp4.Product
                val data = arguments?.getParcelable<Product>(PRODUCT)
                productList.add(data as Product)
                // val data = arguments?.get(PRODUCT)
                // productList.add(data as Product)//NPE. Доставать результат через onActivityResult

            }
        })


    }


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return
        }
        val result = data.getParcelableExtra<Product>(PRODUCT)
    }


    override fun onSelect(product: Product) {//достать результат из onActivityResult и заменить текущее значение product
        val editIntent = Intent(this, EditActivity::class.java)
        editIntent.putExtra(PRODUCT, product)
        startActivity(editIntent)
        //startActivityForResult(editIntent,1)
        //val arguments = intent.extras
        val arguments = onActivityResult(1, 1, editIntent)

        //product = arguments?.getParcelable<Product>(PRODUCT)!!

    }

    override fun onDelete(product: Product) {
      productList.remove(product)
      adapter.setProducts(productList)
    }


}