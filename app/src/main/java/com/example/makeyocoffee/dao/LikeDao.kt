package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Like

@Dao
interface LikeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg like: Like)

    @Update
    suspend fun update(like: Like)

    @Update
    suspend fun update(likes: List<Like>): Int

    @Delete
    suspend fun delete(like: Like)

    @Query("SELECT recipe_id FROM like WHERE recipe_id IN (:recipes)")
    suspend fun getLikesForRecipes(recipes: List<Int>): List<Int>

    @Query("DELETE FROM like WHERE user_id = 1 AND recipe_id = :recipe_id")
    suspend fun deleteLike(recipe_id: Int)

    @Query("INSERT INTO like (user_id, recipe_id) VALUES (1, :recipe_id)")
    suspend fun insertLike(recipe_id: Int)

    @Query("SELECT recipe_id FROM like WHERE user_id = 1")
    suspend fun getAllLikes(): List<Int>
}