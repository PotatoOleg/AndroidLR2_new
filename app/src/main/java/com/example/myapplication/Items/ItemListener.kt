package com.example.myapplication.Items

interface ItemListener {
    fun editItem(oneItem: OneItem)
    fun deleteItem(oneItem: OneItem)
}