package com.example.makeyocoffee.repository

import android.util.Log
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.makeyocoffee.dao.RecipeDao
import com.example.makeyocoffee.entity.Recipe

class RecipeRepository(private val recipeDao: RecipeDao) {

    fun getAllRecipes(): List<Recipe> {
        return recipeDao.getAllRecipes()
    }

    fun getRecipesByFilters(
        grindingList: ArrayList<String>,
        roastingList: ArrayList<String>,
        devicesList: ArrayList<String>
    ): List<Recipe> {
        var query = "SELECT * FROM recipe INNER JOIN device USING(device_id)"

        if (grindingList.isNotEmpty() || roastingList.isNotEmpty() || devicesList.isNotEmpty()) {
            query += " WHERE "
        }

        if (grindingList.isNotEmpty()) {
            query += "grinding IN ("
            for (value in grindingList) {
                query += "\'$value\', "
            }
            query = query.subSequence(0, query.length - 2) as String + ") AND "
        }

        if (roastingList.isNotEmpty()) {
            query += "roasting IN ("
            for (value in roastingList) {
                query += "\'$value\', "
            }
            query = query.subSequence(0, query.length - 2) as String + ") AND "
        }

        if (devicesList.isNotEmpty()) {
            devicesList.add("ANY")
            query += "device_name IN ("
            for (value in devicesList) {
                query += "\'$value\', "
            }
            query = query.subSequence(0, query.length - 2) as String + ") AND "
        }

        if (grindingList.isNotEmpty() || roastingList.isNotEmpty() || devicesList.isNotEmpty()) {
            query = query.subSequence(0, query.length - 4) as String
        }
        Log.d("query", query)
        val rawQuery = SimpleSQLiteQuery(query, arrayOf<Recipe>())
        return recipeDao.getRecipesByFilters(rawQuery)
    }
}