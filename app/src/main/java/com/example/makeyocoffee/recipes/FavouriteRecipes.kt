package com.example.makeyocoffee.recipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.R
import com.example.makeyocoffee.adapter.FavouriteRecipeAdapter
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.entity.Recipe
import com.example.makeyocoffee.repository.LikeRepository
import com.example.makeyocoffee.repository.RecipeRepository

class FavouriteRecipes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite_recipes)

        val adapter = FavouriteRecipeAdapter(applicationContext)
        val recipesView = findViewById<RecyclerView>(R.id.favouriteRecipesRecView)
        recipesView.adapter = adapter
        recipesView.layoutManager =
            LinearLayoutManager(this)

        val db = AppDatabase.getDatabase(this)
        val likeRepo = LikeRepository(db.likeDao())
        val recipeIds = likeRepo.getAllLikes()

        val recipeRepo = RecipeRepository(db.recipeDao())
        val recipes = recipeRepo.getRecipesById(recipeIds)
        recipes.forEach { it.like = 1 }

        adapter.setData(recipes)

        if (recipes.isEmpty()) {
            val textNoFavRecipes = findViewById<TextView>(R.id.textNoFavRecipes)
            textNoFavRecipes.visibility = 1
        }

        adapter.setOnClickListener(object :
            FavouriteRecipeAdapter.OnClickListener {
            override fun onClick(position: Int, model: Recipe) {
                val intent = Intent(this@FavouriteRecipes, RecipeView::class.java)
                intent.putExtra("id", model.recipe_id)
                intent.putExtra("title", model.name)
                intent.putExtra("ingredients", model.ingredients)
                intent.putExtra("instructions", model.description)
                intent.putExtra("image_path", model.imagePath)
                intent.putExtra("like", model.like)
                startActivity(intent)
            }
        })
    }
}