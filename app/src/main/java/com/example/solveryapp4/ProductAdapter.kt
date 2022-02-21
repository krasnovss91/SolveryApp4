package com.example.solveryapp4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

interface OnProductSelected{
    fun onSelect(product: Product)
}

class ProductAdapter(private val products: MutableList<Product>, private val listener: OnProductSelected) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {


   inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(product: Product) {
            itemView.findViewById<TextView>(R.id.name).text = product.name
            itemView.findViewById<TextView>(R.id.producer).text = product.producer
            itemView.findViewById<TextView>(R.id.cost).text = product.cost.toString()

            val drawable = ContextCompat.getDrawable(itemView.context, product.avatar)
            itemView.findViewById<ImageView>(R.id.avatar).setImageDrawable(drawable)

            itemView.setOnClickListener {
                listener.onSelect(product)
            }

                /*
                    private inner class ViewHolder internal constructor(view: View) {
        val addButton: Button
        val removeButton: Button
        val nameView: TextView
        val countView: TextView

        init {
            addButton = view.findViewById(R.id.addButton)
            removeButton = view.findViewById(R.id.removeButton)
            nameView = view.findViewById(R.id.nameView)
            countView = view.findViewById(R.id.countView)
        }
    }

            viewHolder.removeButton.setOnClickListener {
            var count = product.count - 1
            if (count < 0) count = 0
            product.setCount(count)
            viewHolder.countView.text = count.toString() + " " + product.unit
        }
                 */

            itemView.findViewById<Button>(R.id.deleteItemButton).setOnClickListener(
                object : View.OnClickListener{
                    override fun onClick(p0: View?) {
                       delete(product,products)
                    }
                }
            )

        }

       fun delete(product: Product, productList: MutableList<Product>){//вызывать при нажатии на кнопку удаления
           productList.remove(product)
       }

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
