package com.example.makeyocoffee.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.makeyocoffee.dao.ArticleDao
import com.example.makeyocoffee.dao.LikeDao
import com.example.makeyocoffee.dao.RecipeDao
import com.example.makeyocoffee.entity.*

@Database(
    entities = [Article::class, Device::class, Recipe::class, User::class, UserDevice::class, Like::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance =
                        Room.databaseBuilder(context, AppDatabase::class.java, "database")
                            .createFromAsset("databases/MakeYOCoffee.db")
                            .allowMainThreadQueries().build()
                }
            }
            return instance!!
        }
    }

    abstract fun recipeDao(): RecipeDao
    abstract fun likeDao(): LikeDao
    abstract fun articleDao(): ArticleDao
}