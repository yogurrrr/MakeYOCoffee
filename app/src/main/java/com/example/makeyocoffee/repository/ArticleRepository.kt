package com.example.makeyocoffee.repository

import com.example.makeyocoffee.dao.ArticleDao
import com.example.makeyocoffee.entity.Article

class ArticleRepository (private val articleDao: ArticleDao) {
    fun getAllArticles(): List<Article> {
        return articleDao.getAllArticles()
    }
}