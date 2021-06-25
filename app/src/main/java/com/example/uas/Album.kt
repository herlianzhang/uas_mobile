package com.example.uas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "album_table")
data class Album(
    @PrimaryKey
    val id: Int,
    val name: String,
    val realiseDate: String,
    val genre: String,
    val sellCount: Int,
    val totalSell: Int
)