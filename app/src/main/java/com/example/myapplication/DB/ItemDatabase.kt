package com.example.myapplication.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.Dao.ItemDao
import com.example.myapplication.Items.OneItem

@Database(entities = [OneItem::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {

    abstract fun itemDao():ItemDao

    companion object{
        @Volatile
        private var Instance:ItemDatabase? = null

        fun getDatabase(context: Context):ItemDatabase{
            return Instance ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "LR2_database"
                ).build()
                Instance = instance
                instance
            }
        }
    }

}