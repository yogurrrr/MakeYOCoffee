package com.example.makeyocoffee.dao

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
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
    suspend fun getAllRecipes(): List<Recipe>

    @RawQuery
    suspend fun getRecipesByFilters(query: SupportSQLiteQuery) : List<Recipe>

    @Query("SELECT * FROM recipe WHERE recipe_id IN (:recipes)")
    suspend fun getRecipesById(recipes: List<Int>): List<Recipe>
}