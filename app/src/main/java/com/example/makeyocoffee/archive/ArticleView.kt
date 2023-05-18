package com.example.makeyocoffee

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class ArticleView : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)

        // Находим контейнер фрагментов в разметке активности
        val fragmentContainer = findViewById<FrameLayout>(R.id.fragment_container)

        // Создаем экземпляр фрагмента
        lateinit var exampleFragment : Fragment
        when (intent.getStringExtra("title")) {
            "CoffeeBenefits" -> exampleFragment = CoffeeBenefits()
            "CoffeeDivination" -> exampleFragment = CoffeeDivination()
            "CoffeeHistory" -> exampleFragment = CoffeeHistory()
            "CoffeeMyths" -> exampleFragment = CoffeeMyths()
            "HowCoffeeGrows" -> exampleFragment = HowCoffeeGrows()
            "LatteArt" -> exampleFragment = LatteArt()
            "Moka" -> exampleFragment = Moka()
            "PourOver" -> exampleFragment = PourOver()
            "RemovingStains" -> exampleFragment = RemovingStains()
            //"Cappuccino" -> exampleFragment = Cappuccino()
            //"CoffeeCalories" -> exampleFragment = CoffeeCalories()
        }

        // Добавляем фрагмент в контейнер
        supportFragmentManager.beginTransaction()
            .add(fragmentContainer.id, exampleFragment)
            .commit()
    }
}