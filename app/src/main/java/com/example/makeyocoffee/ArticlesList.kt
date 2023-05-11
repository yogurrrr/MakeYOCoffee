package com.example.makeyocoffee

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.adapter.ArticleAdapter
import com.example.makeyocoffee.entity.Article

class ArticlesList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articles_list)

        val adapter = ArticleAdapter()

        val articlesView = findViewById<RecyclerView>(R.id.articlesRecyclerView)
        articlesView.adapter = adapter
        articlesView.layoutManager =
            LinearLayoutManager(this) // когда будет фрагмент вместо this поставить requireContext()
    }
}