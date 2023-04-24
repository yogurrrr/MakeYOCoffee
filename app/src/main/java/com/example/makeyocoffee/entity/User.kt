package com.example.makeyocoffee.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "user_id") @PrimaryKey(autoGenerate = true) val userId: Int,
    @ColumnInfo(name = "name") val name: String
)
