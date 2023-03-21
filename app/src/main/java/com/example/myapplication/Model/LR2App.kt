package com.example.myapplication.Model

import android.app.Application
import com.example.myapplication.DB.ItemDatabase
import com.example.myapplication.DB.ItemsRepository

class LR2App:Application() {
    private val database by lazy { ItemDatabase.getDatabase(this) }
    val repository by lazy { ItemsRepository(database.itemDao()) }
}