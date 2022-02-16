package com.example.solveryapp4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(product: Product) {
            //на строке ниже Attempt to invoke virtual method 'void android.widget.TextView.setText(java.lang.CharSequence)' on a null object reference
            itemView.findViewById<TextView>(R.id.name).text = product.name
            itemView.findViewById<TextView>(R.id.producer).text = product.producer
            itemView.findViewById<TextView>(R.id.cost).text = product.cost.toString()

            val drawable = ContextCompat.getDrawable(itemView.context, product.avatar)
            itemView.findViewById<ImageView>(R.id.avatar).setImageDrawable(drawable)
        }

//дернуть после установки списка у адаптера метод notifyDataSetChanged
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = products[position]
        holder.setData(product)
    }

    override fun getItemCount(): Int = products.size

}
