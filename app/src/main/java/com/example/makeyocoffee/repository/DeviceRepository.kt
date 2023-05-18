package com.example.makeyocoffee.repository

import com.example.makeyocoffee.dao.DeviceDao
import kotlinx.coroutines.runBlocking

class DeviceRepository(private val deviceDao: DeviceDao) {
    fun getDevicesByName(deviceNames: List<String>): List<Int> = runBlocking {
        return@runBlocking deviceDao.getDevicesByName(deviceNames)
    }
}