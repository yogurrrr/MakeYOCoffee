package com.example.makeyocoffee.entity

import androidx.room.*

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
        )],
    indices = [Index(
        value = ["user_id", "device_id"],
        unique = true
    )]
)
data class UserDevice(
    @ColumnInfo(name = "user_device_id") @PrimaryKey(autoGenerate = true) val userDeviceId: Int = 0,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "device_id") val deviceId: Int
)
