package com.example.myapplication

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Items.ItemListener
import com.example.myapplication.Items.OneItem
import com.example.myapplication.databinding.OneItemCellBinding

class itemViewHolder(

    private val context: Context,
    private val binding: OneItemCellBinding,
    private val clickListener: ItemListener

):RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item:OneItem){
        binding.nameOfItem.text=item.name
        binding.costOfItem.text = item.cost

        binding.itemCellContainer.setOnClickListener{
            clickListener.editItem(item)
        }

        binding.deleteButton.setOnClickListener{
            clickListener.deleteItem(item)
        }
    }
}