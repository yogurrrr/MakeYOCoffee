package com.example.makeyocoffee.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "article")
data class Article(
    @ColumnInfo(name = "article_id") @PrimaryKey(autoGenerate = true) val articleId: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "image_path") val imagePath: String
)
