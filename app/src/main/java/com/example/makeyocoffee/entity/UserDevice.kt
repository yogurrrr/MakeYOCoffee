package com.example.makeyocoffee.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "user_device",
    foreignKeys = [
        ForeignKey(
            entity = Device::class,
            parentColumns = ["device_id"],
            childColumns = ["device_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )]
)
data class UserDevice(
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "device_id") val deviceId: Int
)
