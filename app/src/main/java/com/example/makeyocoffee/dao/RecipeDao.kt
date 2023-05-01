package com.example.makeyocoffee.dao

import androidx.room.*
import com.example.makeyocoffee.entity.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg recipe: Recipe)

    @Update
    fun update(recipe: Recipe)

    @Update
    fun update(recipes: List<Recipe>): Int

    @Delete
    fun delete(recipe: Recipe)

//    @Query() TODO: запрос на поиск рецетов (rawquery)

    @Query("SELECT * FROM recipe")
    fun getAllRecipes()
}