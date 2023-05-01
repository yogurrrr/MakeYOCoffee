package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Article
import com.example.makeyocoffee.entity.Device

@Dao
interface DeviceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg device: Device)

    @Update
    fun update(device: Device)

    @Update
    fun update(devices: List<Device>): Int

    @Delete
    fun delete(device: Device)

}