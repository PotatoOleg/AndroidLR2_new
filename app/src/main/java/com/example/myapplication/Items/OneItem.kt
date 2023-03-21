package com.example.myapplication.Items

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "item_table")
class OneItem(
    @ColumnInfo (name = "name") var name:String,
    @ColumnInfo (name = "cost") var cost:String,
    @PrimaryKey (autoGenerate = true) var id:Int = 0
) {

}