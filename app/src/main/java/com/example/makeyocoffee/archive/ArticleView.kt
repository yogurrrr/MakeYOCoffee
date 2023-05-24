package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.makeyocoffee.recipes.FavouriteRecipes

class ArticleView : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_view)

        val constructorButton = findViewById<Button>(R.id.buttonConstuctor)
        val favouriteBtton = findViewById<Button>(R.id.buttonFavorite)
        val articlesListButton = findViewById<Button>(R.id.toArticlesListButton)

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