package com.example.makeyocoffee.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey


@Entity(foreignKeys = [
    ForeignKey(entity = Recipe::class,
        parentColumns = ["device_id"],
        childColumns = ["device_id"],
        onDelete = CASCADE)])
data class Device(
    @ColumnInfo(name = "device_id") @PrimaryKey(autoGenerate = true) val deviceId: Int,
    @ColumnInfo(name = "name") val name: String
)


