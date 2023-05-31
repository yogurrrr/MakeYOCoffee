package com.example.makeyocoffee.recipes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import com.example.makeyocoffee.ArticlesList
import com.example.makeyocoffee.MainActivity
import com.example.makeyocoffee.R

class RecipeView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)
        val constructorButton = findViewById<Button>(R.id.buttonConstuctor)
        val favouriteBtton = findViewById<Button>(R.id.buttonFavorite)
        val articlesListButton = findViewById<Button>(R.id.toArticlesListButton)

        // Находим контейнер фрагментов в разметке активности
        val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
        val name = intent.getStringExtra("title")

        // Создаем экземпляры фрагментов
        val RecipeHolderFragment = RecipeHolder()
        val RecipeHolderTimerFragment = RecipeHolderTimer()

        RecipeHolderFragment.arguments = Bundle().apply {
            putInt("id", intent.getIntExtra("id", 0))
            putString("title", intent.getStringExtra("title"))
            putString("ingredients", intent.getStringExtra("ingredients"))
            putString("instructions", intent.getStringExtra("instructions"))
            putString("image_path", intent.getStringExtra("image_path"))
            putInt("like", intent.getIntExtra("like", -1))
        }
        RecipeHolderTimerFragment.arguments = Bundle().apply {
            putString("title", intent.getStringExtra("title")) //name?
            putString("ingredients", intent.getStringExtra("ingredients"))
            putString("instructions", intent.getStringExtra("instructions"))
        }


        // Добавляем фрагмент в контейнер
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer.id, RecipeHolderFragment)
            .commit()

        // Определяем надо ли включать фрагмент с таймером
        if (name == "Кофе в чашке" || name == "Кофе во френч - прессе" || name == "Кофе V60"){
            supportFragmentManager.beginTransaction()
                .replace(fragmentContainer.id, RecipeHolderTimerFragment)
                .commit()

        }

        favouriteBtton.setOnClickListener {
            val intent = Intent(this, FavouriteRecipes::class.java)
            startActivity(intent)
        }
        articlesListButton.setOnClickListener {
            val intent = Intent(this, ArticlesList::class.java)
            startActivity(intent)
        }
        constructorButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }



}
