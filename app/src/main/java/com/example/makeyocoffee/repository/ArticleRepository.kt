package com.example.makeyocoffee.repository

import com.example.makeyocoffee.dao.ArticleDao
import com.example.makeyocoffee.entity.Article
import kotlinx.coroutines.runBlocking

class ArticleRepository (private val articleDao: ArticleDao) {
    fun getAllArticles(): List<Article> = runBlocking {
        return@runBlocking articleDao.getAllArticles()
    }
}