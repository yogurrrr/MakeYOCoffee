package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.adapter.ArticleAdapter
import com.example.makeyocoffee.adapter.RecipeAdapter
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.entity.Article
import com.example.makeyocoffee.entity.Recipe
import com.example.makeyocoffee.repository.ArticleRepository
import com.example.makeyocoffee.repository.RecipeRepository

class ArticlesList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)

        val adapter = ArticleAdapter()//сюда передать data, предварительно добавив адаптеру конструктор
        val articlesView = findViewById<RecyclerView>(R.id.articlesRecyclerView)
        articlesView.adapter = adapter
        articlesView.layoutManager =
            LinearLayoutManager(this) // когда будет фрагмент вместо this поставить requireContext()

        val db = AppDatabase.getDatabase(this)
        val articleRepo = ArticleRepository(db.articleDao())
        val articles = articleRepo.getAllArticles()
        adapter.setData(articles)

        adapter.setOnClickListener(object :
            ArticleAdapter.OnClickListener {
            override fun onClick(position: Int, model: Article) {
                val intent = Intent(this@ArticlesList, ArticleView::class.java)
                startActivity(intent)
            }
        })
    }
}