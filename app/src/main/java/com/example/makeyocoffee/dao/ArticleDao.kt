package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Article
import com.example.makeyocoffee.entity.Recipe

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg article: Article)

    @Update
    suspend fun update(article: Article)

    @Update
    suspend fun update(articles: List<Article>): Int

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM article")
    fun getAllArticles(): List<Article>
}