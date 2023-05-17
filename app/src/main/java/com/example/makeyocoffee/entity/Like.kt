package com.example.makeyocoffee.entity

import androidx.room.*

@Entity(
    tableName = "like",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Recipe::class,
            parentColumns = ["recipe_id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index(
        value = ["user_id", "recipe_id"],
        unique = true
    )]
)
data class Like(
    @ColumnInfo(name = "like_id") @PrimaryKey(autoGenerate = true) val likeId: Int = 0,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "recipe_id") val recipeId: Int
)