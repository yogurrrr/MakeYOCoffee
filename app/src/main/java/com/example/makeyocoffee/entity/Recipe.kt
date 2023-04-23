package com.example.makeyocoffee.entity

import com.example.makeyocoffee.enums.Bean
import com.example.makeyocoffee.enums.Roasting
import com.example.makeyocoffee.enums.Processing

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class Recipe(
    @ColumnInfo(name = "recipe_id") @PrimaryKey(autoGenerate = true) val recipe_id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "bean") val bean: Bean,
    @ColumnInfo(name = "roasting") val roasting: Roasting,
    @ColumnInfo(name = "processing") val processing: Processing?,
    @ColumnInfo(name = "device_id") val deviceId: Int,
    @ColumnInfo(name = "image_path") val imagePath: String // R.drawable.ic_delete
)