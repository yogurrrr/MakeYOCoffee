package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Device

@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg device: Device)

    @Update
    suspend fun update(device: Device)

    @Update
    suspend fun update(devices: List<Device>): Int

    @Delete
    suspend fun delete(device: Device)

    @Query("SELECT device_id FROM device WHERE device_name IN (:deviceNames)")
    suspend fun getDevicesByName(deviceNames: List<String>): List<Int>
}