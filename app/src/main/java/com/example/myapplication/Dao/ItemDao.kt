package com.example.myapplication.Dao

import androidx.room.*
import com.example.myapplication.Items.OneItem
import java.util.concurrent.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item_table ORDER BY id ASC")
    fun allItems():kotlinx.coroutines.flow.Flow<List<OneItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(oneItem: OneItem)

    @Update
    suspend fun updateItem(oneItem: OneItem)

    @Delete
    suspend fun deleteItem(oneItem: OneItem)
}