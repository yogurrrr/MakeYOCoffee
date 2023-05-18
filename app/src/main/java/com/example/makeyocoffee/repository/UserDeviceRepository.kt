package com.example.makeyocoffee.repository

import com.example.makeyocoffee.dao.UserDeviceDao
import kotlinx.coroutines.runBlocking

class UserDeviceRepository(private val userDeviceDao: UserDeviceDao) {

    fun getDevices(): List<String> = runBlocking {
        return@runBlocking userDeviceDao.getDevices()
    }

    fun updateDevices(devices: List<Int>) = runBlocking {
        userDeviceDao.deleteDevices()
        devices.forEach {
            userDeviceDao.insertDevice(it)
        }
    }
}