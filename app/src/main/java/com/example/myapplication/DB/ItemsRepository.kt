package com.example.myapplication.DB

import androidx.annotation.WorkerThread
import com.example.myapplication.Dao.ItemDao
import com.example.myapplication.Items.OneItem
import kotlinx.coroutines.flow.Flow


class ItemsRepository(private val itemDao:ItemDao) {

    val allItems: Flow<List<OneItem>> = itemDao.allItems()

    @WorkerThread
    suspend fun insertItem(oneItem: OneItem){
        itemDao.insertItem(oneItem)
    }

    @WorkerThread
    suspend fun updateItem(oneItem: OneItem){
        itemDao.updateItem(oneItem)
    }

    @WorkerThread
    suspend fun deleteItem(oneItem: OneItem){
        itemDao.deleteItem(oneItem)
    }
}