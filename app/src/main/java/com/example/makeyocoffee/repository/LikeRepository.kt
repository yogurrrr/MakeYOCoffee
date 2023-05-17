package com.example.makeyocoffee.repository

import com.example.makeyocoffee.dao.LikeDao
import kotlinx.coroutines.runBlocking

class LikeRepository(private val likeDao: LikeDao) {

    fun getLikes(recipes: List<Int>): List<Int> = runBlocking {
        return@runBlocking likeDao.getLikesForRecipes(recipes)
    }

    fun addLike(recipe_id: Int) = runBlocking {
        return@runBlocking likeDao.insertLike(recipe_id)
    }

    fun deleteLike(recipe_id: Int) = runBlocking {
        return@runBlocking likeDao.deleteLike(recipe_id)
    }
}