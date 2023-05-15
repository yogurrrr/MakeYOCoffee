package com.example.makeyocoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView

class RecipeView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)

        // Находим контейнер фрагментов в разметке активности
        val fragmentContainer = findViewById<FragmentContainerView>(R.id.fragmentContainerView)

        // Создаем экземпляр фрагмента
        val exampleFragment = RecipeHolder()

        exampleFragment.arguments = Bundle().apply {
            putInt("id", intent.getIntExtra("id", 0))
            putString("title", intent.getStringExtra("title"))
            putString("ingredients", intent.getStringExtra("ingredients"))
            putString("instructions", intent.getStringExtra("instructions"))
            putString("image_path", intent.getStringExtra("image_path"))
            putInt("like", intent.getIntExtra("like", 0))
        }

        // Добавляем фрагмент в контейнер
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer.id, exampleFragment)
            .commit()
    }

}
