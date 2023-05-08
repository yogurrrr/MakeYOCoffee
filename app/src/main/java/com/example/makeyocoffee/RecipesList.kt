package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.adapter.RecipeAdapter
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.repository.RecipeRepository

class RecipesList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipes_list)

        val adapter = RecipeAdapter()
        val recipesView = findViewById<RecyclerView>(R.id.recipesRecyclerView)
        recipesView.adapter = adapter
        recipesView.layoutManager =
            LinearLayoutManager(this) // когда будет фрагмент вместо this поставить requireContext()

        val intent = intent
        val grindingList = intent.getStringArrayListExtra("grindingList")!!
        val roastingList = intent.getStringArrayListExtra("roastingList")!!
        val devicesList = intent.getStringArrayListExtra("devicesList")!!

        val db = AppDatabase.getDatabase(this) // и здесь, наверное, тоже
        val recipeRepo = RecipeRepository(db.recipeDao())
        val recipes = recipeRepo.getRecipesByFilters(grindingList, roastingList, devicesList)
        adapter.setData(recipes)


        val btn = findViewById<Button>(R.id.buttonShow)
        btn.setOnClickListener {
            val intent = Intent(this, Recipe_view::class.java)
            startActivity(intent)
        }
    }
}