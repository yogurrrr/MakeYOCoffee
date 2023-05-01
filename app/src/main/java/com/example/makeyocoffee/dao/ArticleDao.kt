package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg article: Article)

    @Update
    fun update(article: Article)

    @Update
    fun update(articles: List<Article>): Int

    @Delete
    fun delete(article: Article)
}