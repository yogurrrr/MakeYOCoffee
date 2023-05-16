package com.example.makeyocoffee.entity

import com.example.makeyocoffee.enums.Grinding
import com.example.makeyocoffee.enums.Roasting

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Ignore


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Device::class,
            parentColumns = ["device_id"],
            childColumns = ["device_id"],
            onDelete = ForeignKey.CASCADE
        )],
    tableName = "recipe"
)
data class Recipe(
    @ColumnInfo(name = "recipe_id") @PrimaryKey(autoGenerate = true) val recipe_id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "short_description") val shortDescription: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "ingredients") val ingredients: String,
    @ColumnInfo(name = "grinding") val grinding: Grinding,
    @ColumnInfo(name = "roasting") val roasting: Roasting,
    @ColumnInfo(name = "device_id") val deviceId: Int,
    @ColumnInfo(name = "image_path") val imagePath: String // R.drawable.ic_delete
) {
    @Ignore
    var like: Int = 0
}