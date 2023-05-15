package com.example.makeyocoffee.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.makeyocoffee.R
import com.example.makeyocoffee.entity.Article
import com.example.makeyocoffee.entity.Recipe

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private var articlesList = emptyList<Article>()

    interface OnClickListener {
        fun onClick(position: Int, model: Article)
    }

    private var onClickListener: OnClickListener? = null

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articlesList[position]
        holder.itemView.findViewById<TextView>(R.id.articleName).text = article.title
        holder.itemView.findViewById<TextView>(R.id.imagePath).text = article.imagePath
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, article)
            }
        }
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }


    fun setData(articles: List<Article>) {
        this.articlesList = articles
        notifyDataSetChanged()
    }
}