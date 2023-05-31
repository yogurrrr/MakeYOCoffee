package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.adapter.ArticleAdapter
import com.example.makeyocoffee.database.AppDatabase
import com.example.makeyocoffee.entity.Article
import com.example.makeyocoffee.repository.ArticleRepository

class ArticlesList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)

        val adapter = ArticleAdapter(applicationContext)
        val articlesView = findViewById<RecyclerView>(R.id.articlesRecyclerView)
        articlesView.adapter = adapter
        articlesView.layoutManager =
            LinearLayoutManager(this)

        val db = AppDatabase.getDatabase(this)
        val articleRepo = ArticleRepository(db.articleDao())
        val articles = articleRepo.getAllArticles()
        adapter.setData(articles)

        adapter.setOnClickListener(object :
            ArticleAdapter.OnClickListener {
            override fun onClick(position: Int, model: Article) {
                val intent = Intent(this@ArticlesList, ArticleView::class.java)
                intent.putExtra("title", model.title)
                startActivity(intent)
            }
        })
    }
}