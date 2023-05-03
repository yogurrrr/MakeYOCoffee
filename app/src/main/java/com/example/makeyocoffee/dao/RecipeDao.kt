package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg recipe: Recipe)

    @Update
    suspend fun update(recipe: Recipe)

    @Update
    suspend fun update(recipes: List<Recipe>): Int

    @Delete
    suspend fun delete(recipe: Recipe)

    @Query("SELECT * FROM recipe")
    fun getAllRecipes(): List<Recipe>

    //    @Query() TODO: запрос на поиск рецетов (rawquery)
}