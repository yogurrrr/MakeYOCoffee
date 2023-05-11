package com.example.makeyocoffee

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class ArticleView : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)

        // Находим контейнер фрагментов в разметке активности
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container)

        // Создаем экземпляр фрагмента
        val exampleFragment = Article_cappuccino()

        // Добавляем фрагмент в контейнер
        supportFragmentManager.beginTransaction()
            .add(fragmentContainer.id, exampleFragment)
            .commit()
    }
}