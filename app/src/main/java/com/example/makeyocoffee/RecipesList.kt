package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.adapter.RecipeAdapter
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.entity.Recipe
import com.example.makeyocoffee.repository.LikeRepository
import com.example.makeyocoffee.repository.RecipeRepository

class RecipesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_list)

        val adapter = RecipeAdapter(applicationContext)
        val recipesView = findViewById<RecyclerView>(R.id.recipesRecyclerView)
        recipesView.adapter = adapter
        recipesView.layoutManager =
            LinearLayoutManager(this)

        val intent = intent
        val grindingList = intent.getStringArrayListExtra("grindingList")!!
        val roastingList = intent.getStringArrayListExtra("roastingList")!!
        val devicesList = intent.getStringArrayListExtra("devicesList")!!

        val db = AppDatabase.getDatabase(this)
        val recipeRepo = RecipeRepository(db.recipeDao())
        val recipes = recipeRepo.getRecipesByFilters(grindingList, roastingList, devicesList)

        val recipeIds = mutableListOf<Int>()
        for (recipe in recipes) {
            recipeIds.add(recipe.recipe_id)
        }
        val likeRepo = LikeRepository(db.likeDao())
        val likes = likeRepo.getLikes(recipeIds)

        for (recipe in recipes) {
            if (recipe.recipe_id in likes) {
                recipe.like = 1
            }
        }
        adapter.setData(recipes)

        adapter.setOnClickListener(object :
            RecipeAdapter.OnClickListener {
            override fun onClick(position: Int, model: Recipe) {
                val intent = Intent(this@RecipesList, RecipeView::class.java)
                intent.putExtra("id", model.recipe_id)
                intent.putExtra("title", model.name)
                intent.putExtra("ingredients", model.ingredients)
                intent.putExtra("instructions", model.description)
                intent.putExtra("image_path", model.imagePath)
                intent.putExtra("like", model.like)
                startActivity(intent)
            }
        })

//        val btn = findViewById<Button>(R.id.buttonShow)
//        btn.setOnClickListener {
//            val intent = Intent(this@RecipesList, RecipeView::class.java)
//            startActivity(intent)
//        }
    }
}