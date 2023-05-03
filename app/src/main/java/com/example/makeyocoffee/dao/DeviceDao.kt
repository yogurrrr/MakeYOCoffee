package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Article
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

}