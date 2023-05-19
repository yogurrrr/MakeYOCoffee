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
            "Польза кофе" -> exampleFragment = CoffeeBenefits()
            "Гадание на кофейной гуще" -> exampleFragment = CoffeeDivination()
            "История кофе" -> exampleFragment = CoffeeHistory()
            "Мифы о кофе" -> exampleFragment = CoffeeMyths()
            "Как растет кофе" -> exampleFragment = HowCoffeeGrows()
            "Латте-арт" -> exampleFragment = LatteArt()
            "Гейзерная кофеварка" -> exampleFragment = Moka()
            "Кофе пуровер" -> exampleFragment = PourOver()
            "Как вывести кофейные пятна" -> exampleFragment = RemovingStains()
            //"Капучино" -> exampleFragment = Cappuccino()
            //"Калорийность кофе" -> exampleFragment = CoffeeCalories()
        }

        // Добавляем фрагмент в контейнер
        supportFragmentManager.beginTransaction()
            .add(fragmentContainer.id, exampleFragment)
            .commit()
    }
}