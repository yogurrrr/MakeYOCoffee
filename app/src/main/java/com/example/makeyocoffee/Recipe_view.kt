package com.example.makeyocoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class Recipe_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_view)

        // Находим контейнер фрагментов в разметке активности
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container)

        // Создаем экземпляр фрагмента
        val exampleFragment = Recipe_fp()

        // Добавляем фрагмент в контейнер
        supportFragmentManager.beginTransaction()
            .add(fragmentContainer.id, exampleFragment)
            .commit()
    }

    }
