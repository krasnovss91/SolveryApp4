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

        addButton.setOnClickListener {
            startActivityForResult(saveIntent, REQUEST_CODE_ADD)
        }
    }


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) {
            return

            when(requestCode){
                REQUEST_CODE_ADD -> {

                }
                REQUEST_CODE_EDIT -> {

                }
            }
        }
    }



    override fun onSelect(product: Product) {
        val editIntent = Intent(this, EditActivity::class.java)
        editIntent.putExtra(PRODUCT, product)
        startActivityForResult(editIntent, REQUEST_CODE_EDIT)
    }


    override fun onDelete(product: Product) {
      productList.remove(product)
      adapter.setProducts(productList)
    }


}