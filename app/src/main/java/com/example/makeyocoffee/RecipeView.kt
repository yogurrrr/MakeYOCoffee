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

//        val position = intent.getIntExtra("position", -1)
        exampleFragment.arguments = Bundle().apply {
            putString("title", intent.getStringExtra("title"))
            putString("ingredients", intent.getStringExtra("ingredients"))
            putString("instructions", intent.getStringExtra("instructions"))
        }
//        fragmentTransaction.add(R.id.fragmentContainerView, fragment).commit()

        // Добавляем фрагмент в контейнер
        supportFragmentManager.beginTransaction()
            .replace(fragmentContainer.id, exampleFragment)
            .commit()
    }

}
