package com.example.makeyocoffee.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.makeyocoffee.enums.Device


@Entity(tableName = "device")
data class Device(
    @ColumnInfo(name = "device_id") @PrimaryKey(autoGenerate = true) val deviceId: Int = 0,
    @ColumnInfo(name = "name") val name: Device
)