package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Items.ItemListener
import com.example.myapplication.Items.OneItem
import com.example.myapplication.databinding.OneItemCellBinding
import com.example.myapplication.itemViewHolder

class itemAdapter(
    private val items:List<OneItem>,
    private val clickListener: ItemListener
):RecyclerView.Adapter<itemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = OneItemCellBinding.inflate(from,parent,false)
        return itemViewHolder(parent.context,binding,clickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
}