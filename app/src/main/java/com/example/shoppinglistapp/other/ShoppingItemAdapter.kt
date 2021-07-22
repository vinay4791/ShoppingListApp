package com.example.shoppinglistapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.data.db.entitites.ShoppingItem
import com.example.shoppinglistapp.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)

    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentShoppingItem = items[position]

        val textViewName = holder.itemView.findViewById<TextView>(R.id.tvName)
        textViewName.text = currentShoppingItem.name
        val textViewAmount = holder.itemView.findViewById<TextView>(R.id.tvAmount)
        textViewAmount.text = "${currentShoppingItem.amount}"

        val ivDelete = holder.itemView.findViewById<ImageView>(R.id.ivDelete)
        ivDelete.setOnClickListener {
            viewModel.delete(currentShoppingItem)
        }

        val ivPlus = holder.itemView.findViewById<ImageView>(R.id.ivPlus)
        ivPlus.setOnClickListener {
            currentShoppingItem.amount++
            viewModel.insert(currentShoppingItem)
        }

        val ivMinus = holder.itemView.findViewById<ImageView>(R.id.ivMinus)
        ivMinus.setOnClickListener {
            if(currentShoppingItem.amount > 0) {
                currentShoppingItem.amount--
                viewModel.insert(currentShoppingItem)
            }

        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}