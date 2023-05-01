package com.example.makeyocoffee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.makeyocoffee.entity.*

@Database(entities = [Article::class, Device::class, Recipe::class, User::class, UserDevice::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun quoteDao(): QuoteDao

    companion object {
        private var instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDatabase::class.java, "database")
                            .createFromAsset("sample.db")
                            .build()
                }
            }
            return instance!!
        }
    }
}