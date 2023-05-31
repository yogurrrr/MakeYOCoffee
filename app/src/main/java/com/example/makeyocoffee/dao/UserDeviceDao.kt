package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.UserDevice

@Dao
interface UserDeviceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg userDevice: UserDevice)

    @Update
    suspend fun update(userDevice: UserDevice)

    @Update
    suspend fun update(userDevices: List<UserDevice>): Int

    @Delete
    suspend fun delete(userDevice: UserDevice)

    @Query("SELECT device_name FROM user_device INNER JOIN device USING (device_id) WHERE user_id = 1")
    suspend fun getDevices(): List<String>

    @Query("DELETE FROM user_device WHERE user_id = 1")
    suspend fun deleteDevices()

    @Query("INSERT INTO user_device (user_id, device_id) VALUES (1, :device_id)")
    suspend fun insertDevice(device_id: Int)
}